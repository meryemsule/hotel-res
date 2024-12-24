let currentPosition = 0;
const slider = document.querySelector('.slider');
const slides = document.querySelectorAll('.slide');
const slideWidth = slides[0].offsetWidth;

function moveSlider(direction) {
    const maxPosition = -(slides.length - 1) * slideWidth;
    
    if (direction === 1) { // İleri
        currentPosition = Math.max(currentPosition - slideWidth, maxPosition);
    } else { // Geri
        currentPosition = Math.min(currentPosition + slideWidth, 0);
    }
    
    slider.style.transform = `translateX(${currentPosition}px)`;
}

function startAutoSlide() {
    return setInterval(() => {
        const maxPosition = -(slides.length - 1) * slideWidth;
        currentPosition = currentPosition <= maxPosition ? 0 : currentPosition - slideWidth;
        slider.style.transform = `translateX(${currentPosition}px)`;
    }, 5000);
}

function stopAutoSlide() {
    if (autoSlideInterval) {
        clearInterval(autoSlideInterval);
    }
}

// Otomatik kaydırmayı başlat
let autoSlideInterval = startAutoSlide();

// Mouse events
const sliderContainer = document.querySelector('.slider-container');
sliderContainer.addEventListener('mouseenter', stopAutoSlide);
sliderContainer.addEventListener('mouseleave', () => {
    autoSlideInterval = startAutoSlide();
});

// Touch events için swipe desteği
let touchStartX = 0;
let touchEndX = 0;

slider.addEventListener('touchstart', e => {
    touchStartX = e.touches[0].clientX;
});

slider.addEventListener('touchend', e => {
    touchEndX = e.changedTouches[0].clientX;
    handleSwipe();
});

function handleSwipe() {
    const swipeThreshold = 50;
    const diff = touchStartX - touchEndX;
    
    if (Math.abs(diff) > swipeThreshold) {
        if (diff > 0) {
            moveSlider(1); // İleri
        } else {
            moveSlider(-1); // Geri
        }
    }
}