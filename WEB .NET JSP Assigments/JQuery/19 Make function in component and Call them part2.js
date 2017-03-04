        // _________ the myComponent.js file _____________ // 
$.widget ("mobile.myComponent",$.mobile.widget,
 {
    _create: function () // constructor
    {
        var $elem = this.element;
        $elem.css ({ "background-color" : "red", "color" : "white" });
        $elem.height (200);
        var myLabel = $('<label id="deni"> Hello world </label>');
        myLabel.appendTo($elem);
    },
    myFunction: function(temp1,temp2)
    {
        $('#deni').text(temp1+" , "+temp2);
    }
  });
