$(function(){
	$(".tmui-tips").tmTip();
});

function loading2(target,mark){
	$.loading({target:$(target),mark:1}); 
};

var tzAdmin = {
	timer :null,
	initPage:function(itemCount){
		$(".cpage").tzPage(itemCount, {
			num_edge_entries : 1, //边缘页数
			num_display_entries :4, //主体页数
			num_edge_entries:5,
			current_page:0,
			showGo:true,
			showSelect:true,
			items_per_page : 10, //每页显示X项
			prev_text : "前一页",
			next_text : "后一页",
			callback : function(pageNo,psize){//回调函数
				tzAdmin.loadData(pageNo,psize);
			}
		});
	},
	loadData:function(pageNo,pageSize,callback){
		var keyword = $("#keywords").val();
		var model = $("#tbody").data("model");
		var $this = this;
		$.ajax({
			type:"post",
			beforeSend:function(){loading2($("#tbody"),4);},
			url:adminPath+"/"+model+"/template",
			data:{pageNo:pageNo*pageSize,pageSize:pageSize,keyword:keyword},
			success:function(data){
				var $data = $(data);
				$("#tbody").html($data);//追加元素到dom中
				$(".tmui-tips").tmTip();//日期tip显示（自定义插件：三角显示）
				var itemCount = $data.find("#itemCount").val();
                if (isNotEmpty(keyword))$this.HighLight(keyword);
                if(callback)callback(itemCount);
			}
		});
	},
	search:function(){
//		var keyword = $("#keywords").val();
//			if(isEmpty(keyword)){
//				loading("请输入关键字...",3);
//				$("#keywords").focus();
//				return;
//			}
		tzAdmin.loadData(0,10,function(itemCount){
			tzAdmin.initPage(itemCount);//分页加载一次吗
		});
	},
	HighLight:function (key) {
		if (isEmpty(key))return;
		$("#tbody").find(".keys").each(function () {
			var text = $(this).text();
			// var nt = text.replace(key,"<span class='red'>"+key+"</span>")//这种只能高亮显示第一个关键字
			var reg = new RegExp(key,"ig");//获取text下的所有和key相同的字段并忽略大小写
			var nt = text.replace(reg,"<span class='red'>"+key+"</span>")
			$(this).html(nt);
        });
    },
	op:function(obj){
		var $this = $(obj);
		var opid = $this.attr("opid");
		var mark = $this.attr("mark");
		var val = $this.attr("val");
		var model = $("#tbody").data("model");
		var params = {};
		params[mark] = val;
		params["id"] = opid;
//		alert(JSON.stringify(params));
		clearTimeout(this.timer);
		this.timer = setTimeout(function(){
			loading("请稍后数据执行中...");
			$.ajax({
				type:"post",
				url:adminPath+"/"+model+"/update",
				data:params,
				success:function(data){
					loading("执行成功...",3);
					if(data=="success"){
						$this.attr({opid:opid,val:val==0?1:0}).removeClass().addClass(val==0?"red":"green").text(val==0?"否":"是");
					}
				}
			});
		},200); 
	},
	remove:function(obj){
		$.tzConfirm({title:"友情提示",content:"您确定删除吗?",callback:function(ok){
			if(ok){
				var $this = $(obj);
				var opid = $this.data("opid");
				var model = $("#tbody").data("model");
				clearTimeout(this.timer);
				var params = {};
				params["id"] = opid;
				this.timer = setTimeout(function(){
					loading("请稍后数据执行中...");
					$.ajax({
						type:"post",
						url:adminPath+"/"+model+"/delete",
						data:params,
						success:function(data){
							loading("执行成功...",3);
							$this.parents("tr").remove();
							var len = $("#tbody").find("tr").length;
							if(len==0){
								//window.location.href =window.location.href;
								tzAdmin.loadData(0,10,function(itemCount){
									tzAdmin.initPage(itemCount);//分页加载一次吗
								});
							}
						}
					});
				},200); 
			}
		}});
	}
};