$(function(){
   
   
   $('.btnLogout').on('click', function() {
       $('#dialogLogout').modal('show');
   });
   
   
   $('.page').on('click', function() {
       if(!$(this).parents('li').hasClass('disabled')){
           var urlList = $(this).parents('div').data('list');
           var page = $(this).data('page');
           var itemsPerPage = $('.itemsPerPage').val();
           var urlFinal = urlList+page+'/'+itemsPerPage;
           reloadPagination(urlFinal, page, itemsPerPage);
       }
   });

   $('.itemsPerPage').on('change', function() {
       if(!$(this).parents('li').hasClass('disabled')){
           var urlList = $(this).parents('div').data('list');
           var page = 1;
           var itemsPerPage = $('.itemsPerPage').val();
           var urlFinal = urlList+page+'/'+itemsPerPage;
           
           reloadPagination(urlFinal, page, itemsPerPage);
       }
   });
   
   function reloadPagination(urlFinal, page, itemsPerPage){
       $('<form action='+urlFinal+' method="POST">'+
               '<input type="hidden" name="page" value="' + page + '">' +
               '<input type="hidden" name="itemsPerPage" value="' + itemsPerPage + '">' +
           '</form>').submit();
   }
       
});