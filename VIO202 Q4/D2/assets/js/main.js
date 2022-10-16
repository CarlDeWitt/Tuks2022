/**
 * Template Name: iPortfolio - v3.9.1
 * Template URL: https://bootstrapmade.com/iportfolio-bootstrap-portfolio-websites-template/
 * Author: BootstrapMade.com
 * License: https://bootstrapmade.com/license/
 */
(function () {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim();
    if (all) {
      return [...document.querySelectorAll(el)];
    } else {
      return document.querySelector(el);
    }
  };

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all);
    if (selectEl) {
      if (all) {
        selectEl.forEach((e) => e.addEventListener(type, listener));
      } else {
        selectEl.addEventListener(type, listener);
      }
    }
  };

  /**
   * Easy on scroll event listener
   */
  const onscroll = (el, listener) => {
    el.addEventListener("scroll", listener);
  };

  /**
   * Navbar links active state on scroll
   */
  let navbarlinks = select("#navbar .scrollto", true);
  const navbarlinksActive = () => {
    let position = window.scrollY + 200;
    navbarlinks.forEach((navbarlink) => {
      if (!navbarlink.hash) return;
      let section = select(navbarlink.hash);
      if (!section) return;
      if (
        position >= section.offsetTop &&
        position <= section.offsetTop + section.offsetHeight
      ) {
        navbarlink.classList.add("active");
      } else {
        navbarlink.classList.remove("active");
      }
    });
  };
  window.addEventListener("load", navbarlinksActive);
  onscroll(document, navbarlinksActive);

  /**
   * Scrolls to an element with header offset
   */
  const scrollto = (el) => {
    let elementPos = select(el).offsetTop;
    window.scrollTo({
      top: elementPos,
      behavior: "smooth",
    });
  };

  /**
   * Back to top button
   */
  let backtotop = select(".back-to-top");
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add("active");
      } else {
        backtotop.classList.remove("active");
      }
    };
    window.addEventListener("load", toggleBacktotop);
    onscroll(document, toggleBacktotop);
  }

  /**
   * Mobile nav toggle
   */
  on("click", ".mobile-nav-toggle", function (e) {
    select("body").classList.toggle("mobile-nav-active");
    this.classList.toggle("bi-list");
    this.classList.toggle("bi-x");
  });

  /**
   * Scrool with ofset on links with a class name .scrollto
   */
  on(
    "click",
    ".scrollto",
    function (e) {
      if (select(this.hash)) {
        e.preventDefault();

        let body = select("body");
        if (body.classList.contains("mobile-nav-active")) {
          body.classList.remove("mobile-nav-active");
          let navbarToggle = select(".mobile-nav-toggle");
          navbarToggle.classList.toggle("bi-list");
          navbarToggle.classList.toggle("bi-x");
        }
        scrollto(this.hash);
      }
    },
    true
  );

  /**
   * Scroll with ofset on page load with hash links in the url
   */
  window.addEventListener("load", () => {
    if (window.location.hash) {
      if (select(window.location.hash)) {
        scrollto(window.location.hash);
      }
    }
  });

  /**
   * Hero type effect
   */
  const typed = select(".typed");
  if (typed) {
    let typed_strings = typed.getAttribute("data-typed-items");
    typed_strings = typed_strings.split(",");
    new Typed(".typed", {
      strings: typed_strings,
      loop: true,
      typeSpeed: 100,
      backSpeed: 50,
      backDelay: 2000,
    });
  }

  /**
   * Skills animation
   */
  let skilsContent = select(".skills-content");
  if (skilsContent) {
    new Waypoint({
      element: skilsContent,
      offset: "80%",
      handler: function (direction) {
        let progress = select(".progress .progress-bar", true);
        progress.forEach((el) => {
          el.style.width = el.getAttribute("aria-valuenow") + "%";
        });
      },
    });
  }

  /**
   * Porfolio isotope and filter
   */
  window.addEventListener("load", () => {
    let portfolioContainer = select(".portfolio-container");
    if (portfolioContainer) {
      let portfolioIsotope = new Isotope(portfolioContainer, {
        itemSelector: ".portfolio-item",
      });

      let portfolioFilters = select("#portfolio-flters li", true);

      on(
        "click",
        "#portfolio-flters li",
        function (e) {
          e.preventDefault();
          portfolioFilters.forEach(function (el) {
            el.classList.remove("filter-active");
          });
          this.classList.add("filter-active");

          portfolioIsotope.arrange({
            filter: this.getAttribute("data-filter"),
          });
          portfolioIsotope.on("arrangeComplete", function () {
            AOS.refresh();
          });
        },
        true
      );
    }
  });

  /**
   * Initiate portfolio lightbox
   */
  const portfolioLightbox = GLightbox({
    selector: ".portfolio-lightbox",
  });

  /**
   * Portfolio details slider
   */
  new Swiper(".portfolio-details-slider", {
    speed: 400,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    pagination: {
      el: ".swiper-pagination",
      type: "bullets",
      clickable: true,
    },
  });

  /**
   * Testimonials slider
   */
  new Swiper(".testimonials-slider", {
    speed: 600,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false,
    },
    slidesPerView: "auto",
    pagination: {
      el: ".swiper-pagination",
      type: "bullets",
      clickable: true,
    },
    breakpoints: {
      320: {
        slidesPerView: 1,
        spaceBetween: 20,
      },

      1200: {
        slidesPerView: 3,
        spaceBetween: 20,
      },
    },
  });

  /**
   * Animation on scroll
   */
  window.addEventListener("load", () => {
    AOS.init({
      duration: 1000,
      easing: "ease-in-out",
      once: true,
      mirror: false,
    });
  });

  /**
   * Initiate Pure Counter
   */
  new PureCounter();
})();

class VerticalMouseDrivenCarousel {
  constructor(options = {}) {
    const _defaults = {
      carousel: ".js-carousel",
      bgImg: ".js-carousel-bg-img",
      list: ".js-carousel-list",
      listItem: ".js-carousel-list-item",
    };

    this.posY = 0;

    this.defaults = Object.assign({}, _defaults, options);

    this.initCursor();
    this.init();
    this.bgImgController();
  }

  //region getters
  getBgImgs() {
    return document.querySelectorAll(this.defaults.bgImg);
  }

  getListItems() {
    return document.querySelectorAll(this.defaults.listItem);
  }

  getList() {
    return document.querySelector(this.defaults.list);
  }

  getCarousel() {
    return document.querySelector(this.defaults.carousel);
  }

  init() {
    TweenMax.set(this.getBgImgs(), {
      autoAlpha: 0,
      scale: 1.05,
    });

    TweenMax.set(this.getBgImgs()[0], {
      autoAlpha: 1,
      scale: 1,
    });

    this.listItems = this.getListItems().length - 1;

    this.listOpacityController(0);
  }

  initCursor() {
    const listHeight = this.getList().clientHeight;
    const carouselHeight = this.getCarousel().clientHeight;

    this.getCarousel().addEventListener(
      "mousemove",
      (event) => {
        this.posY = event.pageY - this.getCarousel().offsetTop;
        let offset = (-this.posY / carouselHeight) * listHeight;

        TweenMax.to(this.getList(), 0.3, {
          y: offset,
          ease: Power4.easeOut,
        });
      },
      false
    );
  }

  bgImgController() {
    for (const link of this.getListItems()) {
      link.addEventListener("mouseenter", (ev) => {
        let currentId = ev.currentTarget.dataset.itemId;

        this.listOpacityController(currentId);

        TweenMax.to(ev.currentTarget, 0.3, {
          autoAlpha: 1,
        });

        TweenMax.to(".is-visible", 0.2, {
          autoAlpha: 0,
          scale: 1.05,
        });

        if (!this.getBgImgs()[currentId].classList.contains("is-visible")) {
          this.getBgImgs()[currentId].classList.add("is-visible");
        }

        TweenMax.to(this.getBgImgs()[currentId], 0.6, {
          autoAlpha: 1,
          scale: 1,
        });
      });
    }
  }

  listOpacityController(id) {
    id = parseInt(id);
    let aboveCurrent = this.listItems - id;
    let belowCurrent = parseInt(id);

    if (aboveCurrent > 0) {
      for (let i = 1; i <= aboveCurrent; i++) {
        let opacity = 0.5 / i;
        let offset = 5 * i;
        TweenMax.to(this.getListItems()[id + i], 0.5, {
          autoAlpha: opacity,
          x: offset,
          ease: Power3.easeOut,
        });
      }
    }

    if (belowCurrent > 0) {
      for (let i = 0; i <= belowCurrent; i++) {
        let opacity = 0.5 / i;
        let offset = 5 * i;
        TweenMax.to(this.getListItems()[id - i], 0.5, {
          autoAlpha: opacity,
          x: offset,
          ease: Power3.easeOut,
        });
      }
    }
  }
}

new VerticalMouseDrivenCarousel();

/* VIO section */
$(`.tl1`).on(`clcik`, function () {
  window.location.href = `https://effortless-faun-8e1b92.netlify.app/`;
});

$(`.tl2`).on(`click`, function () {
  window.location.href = `https://resplendent-syrniki-f643de.netlify.app/`;
});

$(`.tl3`).on(`click`, function () {
  window.location.href = `bob.html`;
});

$(`.tl4`).on(`click`, function () {
  window.location.href = `bob.html`;
});
