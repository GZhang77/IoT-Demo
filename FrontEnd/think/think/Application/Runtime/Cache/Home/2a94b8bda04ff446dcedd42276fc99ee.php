<?php if (!defined('THINK_PATH')) exit();?><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<form action="/think/think/index.php/Home/Index/adduser" method="post">
    User ID<input type="text" name="userid" id="ss" onkeyup="getrmb()"><br>
    User Name<input type="text" name="name" id="sss" onblur="getrmb()"><br>
    Bus ID<input type="text" name="busid" id="aa" onkeyup="getrmb()"><br>
    Bus Location<input type="text" name="busloc" id="aaa" onblur="getrmb()"><br>
    Driver Name<input type="text" name="drivername" id="bb" onblur="getrmb()"><br>
    <button>Get On Bus</button>
</form>

<form action="/think/think/index.php/Home/Index/deluser" method="post">
    <input type="text" name="userid"  id="hid" hidden>
    <input type="text" name="name" id="hname" hidden>
    <input type="text" name="busid" id="bid" hidden>
    <input type="text" name="busloc" id="bloc" hidden>
    <input type="text" name="drivername" id="dname" hidden>
    <button>Get Off Bus</button>
</form>

</body>

<script type="text/javascript">
    function getrmb(){
        var num1 = document.getElementById('ss').value;
        if (num1=="") {
            document.getElementById('hid').value = "";
        } else {
            document.getElementById('hid').value = num1;
        }

        var num2 = document.getElementById('sss').value;
        if (num2=="") {
            document.getElementById('hname').value = "";
        } else {
            document.getElementById('hname').value = num2;
        }

        var num3 = document.getElementById('aa').value;
        if (num3=="") {
            document.getElementById('bid').value = "";
        } else {
            document.getElementById('bid').value = num3;
        }

        var num4 = document.getElementById('aaa').value;
        if (num4=="") {
            document.getElementById('blo').value = "";
        } else {
            document.getElementById('blo').value = num4;
        }

        var num5 = document.getElementById('bb').value;
        if (num5=="") {
            document.getElementById('dname').value = "";
        } else {
            document.getElementById('dname').value = num5;
        }



    }
</script>
</html>