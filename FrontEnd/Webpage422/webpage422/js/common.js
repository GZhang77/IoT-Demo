$(function(){

	$("#On").click(function(){
		var userIdentification = $("#userIdentification").val();
		var userName = $("#userName").val();
		var busPlate = $("#busPlate").val();
		var locationId = $("#locationId").val();
		var datas={
			"userIdentification" : userIdentification,
		    "userName" : userName,
		    "busPlate" : busPlate,
		    "locationId" : locationId,
		    "eventType" : 0
		}
		
		$.ajax({
            url:'http://ec2-3-17-148-177.us-east-2.compute.amazonaws.com:8080/api/events/save',
            contentType: "application/json",
            type: "post",
    		dataType: "json",
            data:JSON.stringify(datas),
            success:function(data){
            	console.log(data);
		alert("Get on success!");
            },
            error:function(data){
               
            }

        })
	});
	$("#off").click(function(){
		var userIdentification = $("#userIdentification").val();
		var userName = $("#userName").val();
		var busPlate = $("#busPlate").val();
		var locationId = $("#locationId").val();
		var datas={
		    "userIdentification" : userIdentification,
		    "userName" : userName,
		    "busPlate" : busPlate,
		    "locationId" : locationId,
		    "eventType" : 1
		}
		
		$.ajax({
            url:'http://ec2-3-17-148-177.us-east-2.compute.amazonaws.com:8080/api/events/save',
            contentType: "application/json",
            type: "post",
    		dataType: "json",
            data:JSON.stringify(datas),
            success:function(data){
            	console.log(data);
                alert("Get off success!");
            },
            error:function(data){
               
            }

        })
	});
});