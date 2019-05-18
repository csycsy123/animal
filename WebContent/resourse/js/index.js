const server = "http://localhost:8080/animals";

var animals = null;


function login() {
    console.log("login")
    var username =  $("#username").val();
    if (username.length <= 0){
        $("#msg_login").text("username is empty");
        $("#msg_login").show();
        return;
    }
    var password =  $("#password").val();
    if (password.length <= 0){
        $("#msg_login").text("password is empty");
        $("#msg_login").show();
        return;
    }
    var data = {
        "username":username,
        "password":password,
    }
    console.log(data);
    $("#btn_close_login").click();
    $.ajax({
        url:server+"/login",
        type:"POST",
        data:data,
        success:function(result){
            if (result === "true\r\n"){
                getAnimals();
            }else {
                $("#msg").html("login failed:"+result);
                $("#btn_msg").click();
            }
        },
    });
}

function getAnimals() {
    $.ajax({
        url: server +"/Animalsservlet",
        success: function (result) {
            animals = $.parseJSON(result);
            showAnimals();
        },
        error:function (result) {
            console.log(result);
            $("#msg").html("failed request");
            $("#btn_msg").click();
        }
    });
}

function showAnimals() {
    if (animals == null){
        $("#msg").html("empty animals");
        $("#btn_msg").click();
        return;
    }
    $("#animals_tbody").empty();
    $.each(animals,function (index,obj) {
        $("#animals_tbody").append(
            " <tr > " +
            "   <td class=\"col-md-1\">"+obj.id+"</td>" +
            "   <td class=\"col-md-1\">"+obj.name+"</td>" +
            "   <td class=\"col-md-3\"><img style=\"height: 100%;width: 50%\"   src=\""+obj.cover+"\"></td>" +
            "   <td class=\"col-md-2\">"+obj.description+"</td>" +
            "   <td class=\"col-md-1\">"+obj.distance+"</td>" +
            "   <td class=\"col-md-1\">"+obj.age+"</td>" +
            "   <td class=\"col-md-1\">"+obj.hot+"</td>" +
            "   <td class=\"col-md-2\">" +
            "       <div class=\"row\">" +
            "           <button type=\"button\" class=\"btn btn-primary \" onclick='addAnimal()'>添加</button>" +
            "           <button type=\"button\" class=\"btn btn-warning \" onclick='updateAnimal("+obj.id+")'>修改</button>" +
            "           <button type=\"button\" class=\"btn btn-danger \" onclick='deleteAnimal("+obj.id+")'>删除</button>" +
            "       </div>" +
            "   </td>" +
            "</tr>"
        );
    });
}

function deleteAnimal(id) {
    if (id.length <= 0){
        $("#msg").html("id is empty");
        $("#btn_msg").click();
        return
    }
    var data= "id="+id
    console.log(data)
    $.ajax({
        url:server+"/Animalsservlet?"+data,
        type:"DELETE",
        success:function(result){
            if (result === "true\r\n"){
                $("#msg").html("delete success");
                getAnimals();
                showAnimals();
            }else {
                $("#msg").html("delete failed:"+result);
            }
            $("#btn_msg").click();
        },

    });
}

function findAnimal(id) {
    var animal = null;
    $.each(animals,function (index,a) {
        if (a.id === id){
           animal = a;
           return;
        }
    })
    return  animal;
}

function updateAnimal(id) {
    emptyEditModal();
    $("#edit-title").html("Update Animal");
    animal = findAnimal(id);
    $("#id").val(animal.id);
    $("#name").val(animal.name);
    $("#cover").val(animal.cover);
    $("#description").val(animal.description);
    $("#distance").val(animal.distance);
    $("#age").val(animal.age);
    $("#hot").val(animal.hot);
    $("#btn_edit_modal").click();
}

function addAnimal() {
    emptyEditModal();
    $("#edit-title").html("Add Animal");
    $("#id").val("#");
    $("#btn_edit_modal").click()
}

function addAnimalRequest() {
    var name =  $("#name").val();
    if (name.length <= 0){
        $("#msg_form").text("name is empty");
        $("#msg_form").show();
        return;
    }
    var cover =  $("#cover").val();
    if (cover.length <= 0){
        $("#msg_form").text("cover is empty");
        $("#msg_form").show();
        return;
    }
    var description = $("#description").val();
    if (description.length <= 0){
        $("#msg_form").text("description is empty");
        $("#msg_form").show();
        return;
    }
    var distance = $("#distance").val();
    if (distance.length <= 0){
        $("#msg_form").text("distance is empty");
        $("#msg_form").show();
        return;
    }
    var age = $("#age").val();
    if (age.length <= 0){
        $("#msg_form").text("age is empty");
        $("#msg_form").show();
        return;
    }
    var hot= $("#hot").val();
    if (hot.length <= 0){
        $("#msg_form").text("hot is empty");
        $("#msg_form").show();
        return;
    }
    $("#btn_close_edit").click();
    var data={
            "name":name,
            "age":age,
            "description":description,
            "distance":distance,
            "hot":hot,
            "cover":cover,
    };
    console.log(data);
    $.ajax({
        url:server+"/Animalsservlet",
        type:"POST",
        data:data,
        success:function(result){
            if (result === "true\r\n"){
                $("#msg").html("add success");
                getAnimals();
                showAnimals();
            }else {
                $("#msg").html("add failed:"+result);
            }
            $("#btn_msg").click();
        },
    });
}


function updateAnimalRequest() {
    var id =  $("#id").val();
    if (id.length <= 0){
        $("#msg_form").text("id is empty");
        $("#msg_form").show();
        return
    }
    var name =  $("#name").val();
    if (name.length <= 0){
        $("#msg_form").text("name is empty");
        $("#msg_form").show();
        return
    }
    var cover =  $("#cover").val();
    if (cover.length <= 0){
        $("#msg_form").text("cover is empty");
        $("#msg_form").show();
        return
    }
    var description = $("#description").val();
    if (description.length <= 0){
        $("#msg_form").text("description is empty");
        $("#msg_form").show();
        return
    }
    var distance = $("#distance").val();
    if (distance.length <= 0){
        $("#msg_form").text("distance is empty");
        $("#msg_form").show();
        return
    }
    var age = $("#age").val();
    if (age.length <= 0){
        $("#msg_form").text("age is empty");
        $("#msg_form").show();
        return
    }
    var hot= $("#hot").val();
    if (hot.length <= 0){
        $("#msg_form").text("hot is empty");
        $("#msg_form").show();
        return
    }
    $("#btn_close_edit").click();
    var data= "id="+id+"&name="+name+"&description="+description+
        "&distance="+distance+"&hot="+hot+"&cover="+cover+"&age="+age;
    console.log(data);
    $.ajax({
        url:server+"/Animalsservlet?"+data,
        type:"PUT",
        success:function(result){
            if (result === "true\r\n"){
                $("#msg").html("update success");
                getAnimals();
                showAnimals();
            }else {
                $("#msg").html("update failed:"+result);
            }
            $("#btn_msg").click();
        },
    });
}

function editAnimal() {
    if ( $("#edit-title").html() == "Add Animal"){
        addAnimalRequest();
    }else if($("#edit-title").html() == "Update Animal"){
        updateAnimalRequest();
    }
}

function emptyEditModal() {
    $("#id").val("");
    $("#name").val("");
    $("#cover").val("");
    $("#description").val("");
    $("#distance").val("");
    $("#age").val("");
    $("#hot").val("");
    $("#msg_form").html("");
}