
var idList = 0;
var formPendidikan = {
    
    resetForm: function () {
        $('#formpendidikan')[0].reset();
    },

    postPendidikan: function (idPerson, pendidikantotal) {

        if (pendidikantotal.length == 0) {

            Swal.fire({
                position: 'top-end',
                icon: 'error',
                title: 'Your data is failed to be saved',
                showConfirmButton: false,
                timer: 10000
            });

        } else {
            $.ajax({
                url: '/pendidikan/pakeid?idPerson=' + idPerson,
                method: 'post',
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(pendidikantotal),
                success: function (result) {
                    // console.log(result);

                    if (result.status == 'true') {
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Your data has been saved',
                            showConfirmButton: false,
                            timer: 3500
                        });
                        // alert('berhasil');
                    } else {
                        Swal.fire({
                            position: 'top-end',
                            icon: 'error',
                            title: 'Your data is failed to be saved' + result.message,
                            showConfirmButton: false,
                            timer: 10000
                        });
                        // alert('error');
                    }
                },
                error: function (err) {
                    console.log(err);
                }

            }
            );

        }

        // pendidikantotal = [];
        // while (pendidikantotal.length > 0) {
        //     pendidikantotal.pop();
        // }
        $('#tablePendidikan').dataTable().fnClearTable();

        //return pendidikantotal

    },
    setEditData: function (idArray) {
        // console.log(pendidikantotal);
        //console.log(idArray);
        var isi = pendidikantotal[idArray];
        //console.log(isi);
        $('#formEdit').fromJSON(JSON.stringify(isi));
        $('#modal-edit').modal('show')
        idList = idArray
    },

    saveEditTable: function () {
        var dummysimpen = getJsonForm($("#formEdit").serializeArray(), true);
        pendidikantotal[idList] = dummysimpen;

        $('#modal-edit').modal('hide')

        if ($.fn.DataTable.isDataTable('#tablePendidikan')) {
            //table yg sudah dibentuk menjadi datatable harus d rebuild lagi untuk di instantiasi ulang
            $('#tablePendidikan').DataTable().clear();
            $('#tablePendidikan').DataTable().destroy();
            // console.log('masuk if');
        }

        $('#tablePendidikan').DataTable({
            "lengthChange": false,
            "searching": false,
            "autoWidth": false,
            "responsive": false,
            "bPaginate": false,
            "bInfo": false,
            data: pendidikantotal,
            columns: [
                {
                    title: "Jenjang Pendidikan",
                    data: "jenjang"
                },
                {
                    title: "Institusi Pendidikan",
                    data: "institusi"
                },
                {
                    title: "Tahun Masuk",
                    data: "tahunMasuk"
                },
                {
                    title: "Tahun Lulus",
                    data: "tahunLulus"
                },
                {
                    title: "Action",
                    data: null,
                    render: function (data, type, full, meta) {
                        return "<button class='btn-primary' onclick=formPendidikan.setEditData('" + meta.row + "')>Edit</button>"
                    }
                }
            ]
        });
    },

    savePendidikanTable: function () {

        var dummysimpen = getJsonForm($("#formpendidikan").serializeArray(), true);
        pendidikantotal.push(dummysimpen);

        // console.log(pendidikantotal);
        $('#modal-pendidikan').modal('hide');

        if ($.fn.DataTable.isDataTable('#tablePendidikan')) {
            //table yg sudah dibentuk menjadi datatable harus d rebuild lagi untuk di instantiasi ulang
            $('#tablePendidikan').DataTable().clear();
            $('#tablePendidikan').DataTable().destroy();
            // console.log('masuk if');
        }

        $('#tablePendidikan').DataTable({
            "lengthChange": false,
            "searching": false,
            "autoWidth": false,
            "responsive": false,
            "bPaginate": false,
            "bInfo": false,
            data: pendidikantotal,
            columns: [
                {
                    title: "Jenjang Pendidikan",
                    data: "jenjang"
                },
                {
                    title: "Institusi Pendidikan",
                    data: "institusi"
                },
                {
                    title: "Tahun Masuk",
                    data: "tahunMasuk"
                },
                {
                    title: "Tahun Lulus",
                    data: "tahunLulus"
                },
                {
                    title: "Action",
                    data: null,
                    render: function (data, type, full, meta) {
                        return "<button class='btn-primary' onclick=formPendidikan.setEditData('" + meta.row + "')>Edit</button>"
                    }
                }
            ]
        });

        // return pendidikantotal;

    }
};
