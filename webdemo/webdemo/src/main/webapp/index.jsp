<html>
  <head>
    <meta charset="utf-8" />
    <script>
      function checkRealName() {
        var str = form1.realName.value;
        if (str == "") {
          alert("Please input your real name.");
          form1.realName.focus();
          return;
        } else {
          var objExp = /[a-zA-Z]{2,} [a-zA-Z]{2,}/;
          if (objExp.test(str) == true) {
            alert("Right!");
          } else {
            alert("Wrong!");
          }
        }
      }
    </script>
  </head>
  <body>
    <form name="form1" method="post" action="">
      Please input your name:
      <input name="realName" type="text" id="realName" size="40" /> <br /><br />
      <input
        name="Button1"
        type="button"
        class="btn_grey"
        onClick="checkRealName()"
        value="Check"
      />      
    </form>
  </body>
</html>
