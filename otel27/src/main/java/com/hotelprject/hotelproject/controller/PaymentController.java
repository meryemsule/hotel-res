package com.hotelprject.hotelproject.controller;

import com.hotelprject.hotelproject.model.Reservation;
import com.hotelprject.hotelproject.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PaymentController {

    private final ReservationService reservationService;

    @PostMapping("/reserve/process-payment")
    public String processPayment(
            @RequestParam("cardHolderName") String cardHolderName,
            @RequestParam("cardNumber") String cardNumber,
            @RequestParam("expiryDate") String expiryDate,
            @RequestParam("cvv") String cvv,
            HttpSession session,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        try {
            String username = (String) session.getAttribute("loggedInUser");
            if (username == null) {
                return "redirect:/login";
            }

            // Session'dan rezervasyon bilgilerini al
            @SuppressWarnings("unchecked")
            Map<String, Object> pendingReservation = (Map<String, Object>) session.getAttribute("pendingReservation");
            if (pendingReservation == null) {
                throw new RuntimeException("Rezervasyon bilgileri bulunamadı!");
            }

            // Rezervasyonu oluştur
            Reservation reservation = reservationService.makeReservation(
                    ((Number) pendingReservation.get("roomId")).longValue(),
                    (LocalDate) pendingReservation.get("startDate"),
                    (LocalDate) pendingReservation.get("endDate"),
                    username
            );

            // Session'dan rezervasyon bilgilerini temizle
            session.removeAttribute("pendingReservation");

            // RedirectAttributes kullanarak session bilgilerini koruyarak yönlendirme yap
            redirectAttributes.addFlashAttribute("successMessage", "Ödemeniz başarıyla tamamlandı!");
            redirectAttributes.addFlashAttribute("reservation", reservation);
            redirectAttributes.addFlashAttribute("checkInDate", pendingReservation.get("startDate"));
            redirectAttributes.addFlashAttribute("checkOutDate", pendingReservation.get("endDate"));
            redirectAttributes.addFlashAttribute("totalAmount", pendingReservation.get("totalPrice"));

            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "Ödeme işlemi sırasında bir hata oluştu: " + e.getMessage());
            return "payment";
        }
    }
}