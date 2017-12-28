	<table border="1">
		<tr>
			<th>菜品名称</th>
			<th>菜品价格</th>
			<th>菜品图片</th>
		</tr>
		<tr>
			<td>${map.foodname}</td>
			<td>${map.price}</td>
			<td><a href="../download?path=${map.path}"><img src="../image?path=${map.path}"></a></td>
		</tr>
	</table>


