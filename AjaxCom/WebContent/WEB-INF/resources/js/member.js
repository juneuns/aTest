
$(function(){

	function clearInfo(){
		$('#tname').html('');
		$('#no').html('');
		$('#mname').html('');
		$('#mid').html('');
		$('#mmail').html('');
		$('#jdate').html('');
	}

	$('.listBtn').click(function(){
		var sno = $(this).attr('id');
/*		
		// 방법1
		$('#mno').val(sno);
//		var formData = new FormData($('#frm')[0]);
*/	
		/*
		// 방법 2
		var el = $(document.createElement('form'));
		$(el).attr('method', 'POST');
		$(el).attr('encType', 'multipart/form-data');
		
		var subEl = $(document.createElement('input'));
		$(subEl).attr("name", "mno");
		$(subEl).val(sno);
		$(el).append(subEl);
		
		var formData = new FormData($(el)[0]);
		*/
		// 방법 3
		var formData = new FormData();
		formData.set('mno', sno);

		$('#infobox').slideUp(200, function(){
			$.ajax({
				url: '/euns/member/memberDetail.euns',
				type: 'POST',
				dataType: 'json',
				async: false,
				processData: false,
				contentType: false,
				data: formData,
				success: function(obj){
					clearInfo();
					$('#avt').attr('src', '/euns/img/avatar/' + obj.avatar);
					$('#tname').html(obj.name);
					$('#no').html(obj.mno);
					$('#mname').html(obj.name);
					$('#mid').html(obj.id);
					$('#mmail').html(obj.mail);
					$('#gen').html((obj.gen = 'M')? '남자' : '여자');
					$('#jdate').html(obj.sdate);
					
					$('#infobox').stop().slideDown(300);
				},
				error: function(){
					alert('### 통신에러 ###');
				}
			});
		});
	});
});