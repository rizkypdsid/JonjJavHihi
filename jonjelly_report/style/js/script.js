$(document).ready(function() {

    $('#keyword').on('keyup', function() {
        
        $.get('style/ajax/search.php?keyword=' + $('#keyword').val(), function(data) {
            $('#container').show();
            $('#container').html(data);
        });

    });

});
