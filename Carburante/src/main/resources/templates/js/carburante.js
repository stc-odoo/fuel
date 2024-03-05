$('#sortTable').DataTable( {
    
	columnDefs : [
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [5] // Apply this render function to the second column (index 1)
                },
                
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [7] // Apply this render function to the second column (index 1)
                },
                
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [8] // Apply this render function to the second column (index 1)
                }
            ],
    
	
	
	
      drawCallback: function () {
        var api = this.api();        
        $( api.column(5).footer() ).html("<b> € "+ api.column( 5, {page:'current'} ).data().sum().toFixed(3)+"</b>"
        );        
        $( api.column(3).footer() ).html("<b>"+api.column( 3, {page:'current'} ).data().sum()+"</b>"
        );
        $( api.column(8).footer() ).html("<b> € "+ api.column( 8, {page:'current'} ).data().sum().toFixed(3)+"</b>"
        ); 
        
      }
      
      
                 
      
   } );
   
$('#sortTable1').DataTable( {
      drawCallback: function () {
        var api = this.api();        
        $( api.column(5).footer() ).html("<b> € "+api.column( 5, {page:'current'} ).data().sum().toFixed(3)+"</b>"
        );        
        $( api.column(3).footer() ).html("<b>"+api.column( 3, {page:'current'} ).data().sum()+"</b>"
        );
         $( api.column(8).footer() ).html("<b> € "+ api.column( 8, {page:'current'} ).data().sum().toFixed(3)+"</b>"
        ); 
      },
      
      columnDefs : [
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [5] // Apply this render function to the second column (index 1)
                },
                
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [7] // Apply this render function to the second column (index 1)
                },
                
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [8] // Apply this render function to the second column (index 1)
                }
            ]
   //Fine            
   } );  
   
$('#sortTable2').DataTable( {
      drawCallback: function () {
        var api = this.api();        
        $( api.column(5).footer() ).html("<b> € "+api.column( 5, {page:'current'} ).data().sum().toFixed(3)+"</b>"
        );        
        $( api.column(3).footer() ).html("<b>"+api.column( 3, {page:'current'} ).data().sum()+"</b>"
        );
         $( api.column(8).footer() ).html("<b> € "+ api.column( 8, {page:'current'} ).data().sum().toFixed(3)+"</b>"
        ); 
      },
      
      columnDefs : [
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [5] // Apply this render function to the second column (index 1)
                },
                
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [7] // Apply this render function to the second column (index 1)
                },
                
                {
                    "render": function ( data, type, row ) {
                        // Format double values to two decimal places
                        if (type === 'display') {
                            return parseFloat(data).toFixed(3);
                        }
                        return data;
                    },
                    "targets": [8] // Apply this render function to the second column (index 1)
                }
            ]
   } );   