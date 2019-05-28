function submit(e) {
    var formData = {
        name: uname.value,
        sex: sex.value,
        age: age.value
    };

    $.ajax({
        url: 'http://localhost:7777/input',
        type: 'post',
        data: formData,
        dataType: 'json',
        success: function (data) {
            if (data.code ===200){
                alert("Success!");
                console.log('???小逼崽子又在暗示我？');
            }
        },
        error: function (err) {
            console.log('你把你闪现给我交了');
        }
    })

}

$(document).ready(function(e) {
    $('#submit').on('click', submit);
})