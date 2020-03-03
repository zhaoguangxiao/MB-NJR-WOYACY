function setFontSize(){
  var html = document.getElementsByTagName('html')[0];
  var width = window.innerWidth;
  var fontSize = 100/375*width;
  if(width>=640){
      // 320-200 375-170.667 640-100 750-85.333
      html.style.fontSize = 170.667 +'px';
      return;
  }
  html.style.fontSize = fontSize +'px';
}
setFontSize();
window.onresize = function(){
  setFontSize()
};
