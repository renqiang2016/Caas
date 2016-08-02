var TableAjax = function () {

    var handleRecords = function () {

        var grid = new Datatable();

        grid.init({
            src: $("#datatable_ajax"),
            onSuccess: function (grid) {
                // execute some code after table records loaded
            },
            onError: function (grid) {
                // execute some code on network or other general error  
            },
            onDataLoad: function(grid) {
                // execute some code on ajax data load
            },
            loadingMessage: 'Loading...',
            dataTable: { // here you can define a typical datatable settings from http://datatables.net/usage/options 
                //"dom": "<'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'<'table-group-actions pull-right'>>r><'table-scrollable't><'row'<'col-md-8 col-sm-12'pli><'col-md-4 col-sm-12'>>", // datatable layout
                    
                "dom": "<'row'<'col-md-4 col-sm-12'l><'col-md-8 col-sm-12 pull-right'<'table-group-actions pull-right'>>r><'table-scrollable't><'row'<'col-md-8 col-sm-12'i><'col-md-4 col-sm-12'p>>",
                 

                "bStateSave": true, // save datatable state(pagination, sort, etc) in cookie.

                "lengthMenu": [
                    [5,10, 20, 50, 100, 150, -1],
                    [5,10, 20, 50, 100, 150, "All"] // change per page values here
                ],
                "pageLength": 5, // default record count per page
                "ajax": {
                	 url:"../js/data/data1.txt"
                 }, 
                 "processing": false,
                 "serverSide": false,
                 "columns":[
                     {"data":"check"},
                     {"data":"vmName"},
                     {"data":"image"},
                     {"data":"ipAddr"},
                     {"data":"flavor"},
                     {"data":"status"},
                     {"data":"zone"},
                     {"data":"createTime"},
                     {"data":"actions"}
                 ],
                //  "language": {
                //     "aria": {
                //         "sortAscending": ": activate to sort column ascending",
                //         "sortDescending": ": activate to sort column descending"
                //     },
                //     "emptyTable": "No data available in table",
                //     "info": "Showing _START_ to _END_ of _TOTAL_ entries",
                //     "infoEmpty": "No entries found",
                //     "infoFiltered": "(filtered from _MAX_ total entries)",
                //     "lengthMenu": "  _MENU_ records",
                //     "paginate": {
                //         "previous":"Prev",
                //         "next": "Next",
                //         "last": "Last",
                //         "first": "First"
                //     },
                //     "search": "Search:",
                //     "zeroRecords": "No matching records found"
                // },
                "language": {
                    "emptyTable": "无数据",
                    "metronicGroupActions": "",
                    "info": "显示第 _START_ 到 _END_ 条记录，共 _TOTAL_ 条记录",
                    "infoEmpty": "没有记录",
                    "infoFiltered": "",
                    "lengthMenu": "  _MENU_ ",
                    "paginate": {
                        "previous":"上一页",
                        "next": "下一页",
                        "last": "最后一页",
                        "first": "第一页"
                    },
                    "search": "Search:",
                    "zeroRecords": "No matching records found"
                },         
                "pagingType": "full_numbers",
                "order": [
                    [1, "asc"]
                ]// set first column as a default sort by asc
            }
        });
    }

    return {

        init: function () {
            handleRecords();
        }

    };

}();