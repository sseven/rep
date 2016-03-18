	
	//	创建diary
	var createDiary1 = function(o) {
		var rs = 
			'<div>' +
			'<ul class="work_projects">' + 
				'<li ' + (o.firstImage ? 'class="mli2"' : 'class="mli1"') + '>' + 
					'<div class="project_description">' + 
						'<h2 class="title">' + o.name + '</h2>' + 
						'<div class="pcontent1">' + o.content + '</div>' + 
						'<div class="dateInfo" >' + o.createDate + ' 查看详情</div>' + 
					'</div>' + 
				'</li>';
				
		if(o.firstImage) {
			rs += '<li class="mli0">';
			rs += '<div ><img src="' + o.firstImage + '" width="220" /></div>';
			rs += '</li>';
		}
			rs += '</ul>'
			'</div>';
		return rs;
	}
	
	var blockDivMouse = function(f, i) {
		if(f == 1)
			$("#block_" + i).addClass('backDivMouseover');
		else 
			$("#block_" + i).removeClass('backDivMouseover');
	}
	
	var diaryDetail = function(did) {
	
		$('#diaryDetailFrame').attr('src', basePath + 'diary/detail?did=' + did);
		$('#popupShadow').show();
		$('#closeBtn').show();
		$('.diaryDetaiPopup').show();
	}
	
	var popupClose = function() {
		$('#closeBtn').hide();
		$('#popupShadow').hide();
		$('.diaryDetaiPopup').hide();
	}
	
	var createDiary = function(o, index) {
		var rs = 
			'<div id="block_' + index + '" class="blockDiv" onmouseover="blockDivMouse(1, ' + index + ')" onmouseout="blockDivMouse(2, ' + index + ')" >'
							+ '<div >'
							+ '<a class="title" href="#" onclick="diaryDetail(\'' + o.id + '\'); return false;">' + o.name + (o.firstImage?' (图)' : '')
							+ '</a> </div>' 
							+ '<div class="content">'
							+ o.content
							+ '</div>'
							+ '<div class="bottomInfo">'
							+ '<span class="cd">' + o.createDate + '</span>'
							//	+ '<span ><a href="#" onclick="return false;">赞</a></span>'
							+ '<span ><a href="#" onclick="diaryDetail(\'' + o.id + '\'); return false;">详情</a></span>'
							+ '</div>'
						+ '</div>';
		return rs;
	}

	var setScreenCenter = function(id) {
		var wih = window.innerHeight;
	    var wiw = window.innerWidth;
	    var bst = document.body.scrollTop;
	    var ow = $("#spinner").width();
		var oh = $("#spinner").height();
	    var left = (wiw - ow) / 2;
	    var top = bst + (wih - oh) / 2;
		$("#spinner").css('position', 'absolute');
		$('#spinner').css('left', left);
		$('#spinner').css('top', top);
	}
	

	//	$(".figcaption").each(function(i){
	//    var divH = $(this).height();
	//    var $p = $("p", $(this)).eq(0);
	//    while ($p.outerHeight() > divH) {
	//        $p.text($p.text().replace(/(\s)*([a-zA-Z0-9]+|\W)(\.\.\.)?$/, "..."));
	//    };
	//  });