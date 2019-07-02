
var prefix = "/biz/policy"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
                        pagination : true, // 设置为true会在底部显示分页条
                        paginationShowPageGo: true, //设置为true在底部显示分页跳转
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
                                filename:$('#searchName').val(),
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
								{
                                    field : '',
                                    title: '序号',
                                    formatter: function (value, row, index) {
                                        return index+1;
                                    }
								},
								{   visible :false,
									field : 'id',
									title : '文件id'
								},
							    {
                                    field : 'deptName',
                                    title : '适用项目'
                                },
								{
									field : 'filename', 
									title : '文件名',
                                    formatter: function(value,row,index){
                                        return '<a href="#" onclick="downloadFile(\''+row.id+'\')">'+row.filename+'</a>';
                                    }
								},
								{   visible :false,
									field : 'url', 
									title : '文档URL地址' 
								},
								{
									field : 'policyType',
									title : '文档类型' 
								},
								{
									title : '操作',
									field : 'operation',
									align : 'center',
									formatter : function(value, row, index) {
                                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                                + row.id
                                                + '\')"><i class="fa fa-edit"></i></a> ';
                                            var d = '<a class="btn btn-warning btn-sm ' +s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="removePolicy(\''
                                                + row.id
                                                + '\')"><i class="fa fa-remove"></i></a> ';
                                            var dl = '<a class="btn btn-success btn-sm '+s_download_h+'" href="#" title="下载"  mce_href="#" onclick="downloadFile(\''
                                                + row.id
                                                + '\')"><i class="fa fa-download"></i></a> ';
                                            return e + dl + d;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	var addPage = layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
        area : [ '65%', '65%' ],
		content : prefix + '/add' // iframe的url
	});
	layer.full(addPage);
}

function downloadFile(id) {
    location.href= prefix + '/download/' + id;
}

function edit(id) {
    var editPage = layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '65%', '65%' ],
        content : prefix + '/edit/' + id // iframe的url
    });
    layer.full(editPage);
}
function removePolicy(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url :  prefix + "/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                    reLoad();
                }
            }
        });
    })
}