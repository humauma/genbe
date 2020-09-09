var formBiodata = {
    resetForm: function () {
        $('#formprofile')[0].reset();
    },

    saveForm: function () {

        var dataResult = getJsonForm($("#formprofile").serializeArray(), true);

        $.ajax({
            url: '/person',
            method: 'post',
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(dataResult),
            success: function (result) {
                console.log(result);
                $('#modal-biodata').modal('hide')

                if (result.status == 'true') {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: 'Your data has been saved',
                        showConfirmButton: false,
                        timer: 1000
                    })
                } else {
                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: 'Your data is failed to be saved' + result.message,
                        showConfirmButton: false,
                        timer: 3000
                    })
                }
            },
            error: function (err) {
                console.log(err);
            }

        }
        );


    }, getBiodata: function (nik) {
        //formBiodata.resetForm();

        if ($.fn.DataTable.isDataTable('#mytable')) {
            //table yg sudah dibentuk menjadi datatable harus d rebuild lagi untuk di instantiasi ulang
            $('#mytable').DataTable().clear();
            $('#mytable').DataTable().destroy();
        }

        $.ajax({
            url: '/person/' + nik,
            method: 'get',
            contentType: 'application/json',
            dataType: 'json',

            success: function (result) {
                //var hasil = JSON.stringify(result),
                console.log(result[0]);

                // var coba = JSON.stringify(result);
                // console.log(coba);
                // console.log(coba.message);

                if (result[0].status == 'true') {
                    $('#mytable').DataTable({
                        "lengthChange": false,
                        "searching": false,
                        "autoWidth": false,
                        "responsive": false,
                        "bPaginate": false,
                        "bSort": false,
                        "bInfo": false,
                        data: [result[0].data],
                        columns: [
                            {
                                title: "Nik",
                                data: "nik"
                            },
                            {
                                title: "Nama",
                                data: "name"
                            },
                            {
                                title: "Alamat",
                                data: "adress"
                            },
                            {
                                title: "Nomor hp",
                                data: "hp"
                            },
                            {
                                title: "Tanggal Lahir",
                                data: "tgl"
                            },
                            {
                                title: "Tempat Lahir",
                                data: "tmptLahir"
                            },
                            {
                                title: "Umur",
                                data: "umur"
                            },
                            {
                                title: "Pendidikan Terakhir",
                                data: "pddknTerakhir"
                            }
                        ]
                    });

                } else {

                    Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: result[0].message,
                        showConfirmButton: false,
                        timer: 3000
                    })

                }
            },
            error: function (err) {
                console.log(err);
            }
        });

    }

};
