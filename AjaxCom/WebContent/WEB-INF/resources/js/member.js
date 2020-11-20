$(function(){
	$('.listBtn').on('click', function(){
		var sno = $(this).attr('id');
		$('#mno').val(sno);
		
		$('#infobox').stop().slideUp(300);
		
		var el = $(document.createElement('form'));
		$(el).attr('method', 'POST');
		$(el).attr('encType', 'multipart/form-data');
		
		var subEl = $(document.createElement('input'));
		$(subEl).attr("name", "mno");
		$(subEl).val(sno);
		$(el).append(subEl);
		
		//var formData = new FormData($(el)[0]);
		
		formData = new FormData($('#frm')[0]);
		function clearInfo(){
			$('#tname').html('');
			$('#no').html('');
			$('#mname').html('');
			$('#mid').html('');
			$('#mmail').html('');
			$('#jdate').html('');
		}
		
		$.ajax({
			url: '/euns/member/memberDetail.euns',
			type: 'POST',
			processData: false,
			contentType: false,
			data: formData,
			success: function(obj){
				obj = JSON.parse(obj);
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