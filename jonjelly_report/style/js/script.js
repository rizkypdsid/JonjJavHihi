$(document).ready(function() {
    $('#loader').hide();

    $('#keyword').on('keyup', function() {
        $('#loader').show();
        $('#Btncari').hide();
        $('#container').hide();

        $.get('style/ajax/search.php?keyword=' + $('#keyword').val(), function(data) {
            $('#container').show();
            $('#container').html(data);
            $('#Btncari').show();
            $('#loader').hide();
        });
    });

});
