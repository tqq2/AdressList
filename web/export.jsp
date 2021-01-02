<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2020/12/31
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         import="java.util.*,java.io.*,java.sql.*,util.ExportExcelUtil"
%>

<%
    PrintWriter outs = response.getWriter();
    ExportExcelUtil export = new ExportExcelUtil();
    String filename = "D:\\addresslist.xls";
    export.createTableHeader();

    try {

        ResultSet rs = export.selectAllDataFromDB(session
                .getAttribute("sql")
                + "");
        int rowIndex = 1;
        while (rs.next()) {
            List<String> list = new ArrayList<String>();
            for (int i = 1; i <= ExportExcelUtil.columNumber; i++) {
                list.add(rs.getString(i));
            }
            export.createTableRow(list, (short) rowIndex);
            rowIndex++;
            System.out.println("11");
        }

        export.expord(new FileOutputStream(filename));

    } catch (Exception e) {
        e.printStackTrace();
    }

    // 取得文件名。
    File file = new File(filename);
    if (!file.exists()) {
        file.createNewFile();
    }

    //以流的形式下载文件。
    InputStream fis = new BufferedInputStream(new FileInputStream(file));
    byte[] buffer = new byte[fis.available()];
    fis.read(buffer);
    fis.close();

    response.reset();

    response.addHeader("Content-Disposition", "attachment;filename="
    + new String("通讯录信息.xls".getBytes("utf-8"), "ISO-8859-1"));
    response.addHeader("Content-Length", "" + file.length());
    OutputStream toClient = new BufferedOutputStream(response
    .getOutputStream());
    response.setContentType("application/octet-stream");//二进制流，不知道下载文件类型
    toClient.write(buffer);
    toClient.flush();
    toClient.close();

    out.clear();
    out = pageContext.pushBody();

%>

