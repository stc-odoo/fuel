fetch('/barchart')
	.then(response => response.json())
	.then(data => {
		var ctx = document.getElementById('barChart').getContext('2d');
		var chart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: data.labels,
				datasets: [{
					label: 'BENZINA',
					data: data.values,
					backgroundColor: 'rgba(75, 192, 192, 0.2)',
					borderColor: 'rgba(75, 192, 192, 1)',
					borderWidth: 1
				}, 
				{
					
					label: 'DIESEL',
					data: data.values1,
					backgroundColor: 'rgba(243, 24, 18, 0.1)',
					borderColor: 'rgba(243, 24, 18, 1)',
					borderWidth: 1
				},
				
				{label: 'SUPREME',
					data: data.values2,
					backgroundColor: 'rgba(18, 24, 243, 0.1)',
					borderColor: 'rgba(18, 24, 243,1)',
					borderWidth: 1
				}]
			},
			options: {
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				}
			}
		});
	});
	
fetch('/barchart1')
	.then(response => response.json())
	.then(data => {
		var ctx = document.getElementById('barChart1').getContext('2d');
		var chart = new Chart(ctx, {
			type: 'bar',
			data: {
				labels: data.labels,
				datasets: [{
					label: 'BENZINA',
					data: data.values,
					backgroundColor: 'rgba(75, 192, 192, 0.2)',
					borderColor: 'rgba(75, 192, 192, 1)',
					borderWidth: 1
				}, 
				{
					
					label: 'DIESEL',
					data: data.values1,
					backgroundColor: 'rgba(243, 24, 18, 0.1)',
					borderColor: 'rgba(243, 24, 18, 1)',
					borderWidth: 1
				},
				
				{label: 'SUPREME',
					data: data.values2,
					backgroundColor: 'rgba(18, 24, 243, 0.1)',
					borderColor: 'rgba(18, 24, 243,1)',
					borderWidth: 1
				}]
			},
			options: {
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						}
					}]
				}
			}
		});
	});