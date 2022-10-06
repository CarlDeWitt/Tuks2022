var prevScrollpos = window.pageYOffset;
window.onscroll = function () {
  var currentScrollPos = window.pageYOffset;
  if (prevScrollpos > 300) {
    document.getElementById("navbar").style.top = "-700px";
  } else {
    if (prevScrollpos > currentScrollPos) {
      document.getElementById("navbar").style.top = "0";
    } else {
      document.getElementById("navbar").style.top = "-700px";
    }
  }

  prevScrollpos = currentScrollPos;
};
