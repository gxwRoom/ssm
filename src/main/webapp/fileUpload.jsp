<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC文件上传</title>
</head>
<body>
      <h3>SpringMVC文件上传</h3>
      <hr/>
      <!--
         SpringMVC文件上传:
         前提要求：
              1) form表单的enctype的取值是multipaert/form-data。
                 enctype：表示表单请求正文类型。
              2) Method的属性取值必须是post
              3) 提供一个文件选择域：<input  type=”file”/>
      -->
      <form action="user/fileUpload" method="post" enctype="multipart/form-data">
           文件选择：<input type="file" name="upload"/><br/>
           <input type="submit" value="上传"/>
      </form>
</body>
</html>
