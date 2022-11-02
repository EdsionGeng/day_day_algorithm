//package com.edison.algorithm.string;
//
//import edp.davinci.core.utils.POIUtils;
//import edp.davinci.dao.GetListOfFileServiceMapper;
//import edp.davinci.dao.ListQueryInterfaceMapper;
//import edp.davinci.dto.fileDto.CreateOrEditInterfacesDto;
//import edp.davinci.dto.fileDto.ExcelOfDetialDto;
//import edp.davinci.model.UpOrDownFile.PublicResp;
//import edp.davinci.req.ExcelOfDetialReq;
//import edp.davinci.req.ExcelOfDetialRequest;
//import edp.davinci.req.ExecuteShellOforderRequest;
//import edp.davinci.service.upOrDownFile.UpdateExcelService;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.FileUtils;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FileStatus;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;
//import org.apache.poi.hssf.usermodel.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.SingleConnectionDataSource;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.sql.Connection;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Properties;
//import java.util.UUID;
//
//
//@Service
//@Slf4j
//public class UpdateExcelServiceImpl implements UpdateExcelService {
//    @Autowired
//    GetListOfFileServiceMapper getListOfFileServiceMapper;
//    @Autowired
//    ListQueryInterfaceMapper listQueryInterfaceMapper;
//    private static String JDBC_DRIVER = "org.apache.hive.jdbc.HiveDriver";
//    private static String CONNECTION_URL = "jdbc:hive2://10.10.220.75:10000/default";
//    private static String username = "";
//    private static String password = "";
//    private static Connection con = null;
//    private boolean execute = true;
//
//    @Value("${getimpala.driver}")
//    private String impalaDriver;
//    @Value("${getimpala.url}")
//    private String impalaUrl;
//    @Value("${getimpala.username}")
//    private String impalaUsername;
//    @Value("${getimpala.password}")
//    private String impalaPassword;
//    @Value("${hive.ip}")
//    private String hiveIP;
//
//    @SneakyThrows
//    @Override
//    //  废弃
//    public PublicResp updateOnlyExcel(MultipartFile file) {
//        PublicResp publicResp = new PublicResp();
//        String dst = "";
//        try {
//            //将将excel转化成List<String[]>类型
//            List<String[]> list = POIUtils.readExcel(file);//工具类最后
//            //文件名
//            String name = UUID.randomUUID().toString();
//            //设置文件存的地址
//            File directory = new File("");//参数为空
//            String courseFile = directory.getCanonicalPath() ;
//            //将文件存入当前文件夹，并转化成csv文件
//            boolean excel = ListToCvs.createCsvFile(list, courseFile, name);//工具类在最后
//            //文件地址
//            dst = courseFile +"\t"+ name+ ".csv";
//            Class.forName(JDBC_DRIVER);
//            con = (Connection) DriverManager.getConnection(CONNECTION_URL,username,password);
//            Statement stmt = con.createStatement();
////            String sql = " load data local inpath '" + dst + "' overwrite into table hmd_api.imp_ai_call_list ";
//            String sql = "load data local inpath 'D:\\gitproject\\udp_work01\\davinci-dev-0.3\\896c7c8e-b6f4-46cb-b566-db536a65f1a8.csv' overwrite into table hmd_api.imp_ai_call_list ";
//            System.out.println("sql = " + sql);
//            //执行sql
//            execute = stmt.execute(sql);
//            File f = new File(dst);
//            if(!f.exists()){
//                f.delete();
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            publicResp.setRespCode("9999");
//            publicResp.setMsg(e.toString());
////            File f = new File(dst);
////            if(!f.exists()){
////                f.delete();
////            }
//            return publicResp;
//        }
//        publicResp.setRespCode("0000");
//        return publicResp;
//        return null;
//    }
//
//    //  废弃
//    public PublicResp updateOnlyExcelOfTwo(MultipartFile file) {
////        PublicResp publicResp = new PublicResp();
////        String hiveIP = "hdfs://10.10.220.76:8020";
////        String dst = null;
////        try {
////            List<String[]> list = POIUtils.readExcel(file);//工具类最后
////            //文件名
////            String name = UUID.randomUUID().toString();
////            //设置文件存的地址
////            File directory = new File("");//参数为空
////            String courseFile = directory.getCanonicalPath() ;
////            //将文件存入当前文件夹，并转化成csv文件
////            boolean excel = ListToCvs.createCsvFile(list, courseFile, name);//工具类在最后
////            //文件地址
////            dst = courseFile +"\\"+ name+ ".csv";
////            FileSystem fs = null;
////            Configuration config = new Configuration();
////            config.set("fs.defaultFS",hiveIP);
////            config.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
////            fs = FileSystem.get(config);
////            Path srcPath = new Path(dst);
////            Path dstPath = new Path("/opt/user/hive/warehouse/hmd_api.db/imp_ai_call_list");
////            fs.copyFromLocalFile(srcPath,dstPath);
////            File file1 = new File(dst);
////            file1.delete();
////        } catch (Exception e) {
////            File file1 = new File(dst);
////            file1.delete();
////            e.printStackTrace();
////            publicResp.setRespCode("9999");
////            publicResp.setMsg(e.toString());
////            return publicResp;
////        }
////        publicResp.setRespCode("0000");
////        return publicResp;
//        return null;
//    }
//
//    //  废弃
//    @Override
//    public String updateExcel2GetTaskName(String taskName) {
////        return getListOfFileServiceMapper.getFileOftablePath(1);
//        return null;
//    }
//
//    @SneakyThrows
//    @Override
//    public PublicResp updateExcel2ByGetTaskName(Integer taskId, MultipartFile file) {
//        String updateExcelOfType = listQueryInterfaceMapper.getUpdateExcelOfType(taskId);
//        PublicResp publicResp = new PublicResp();
//        //String hiveIP = "hdfs://10.0.15.134:8020";
//        String dst = null;
//        //文件名
//        String name = UUID.randomUUID().toString();
//        File filew = null;
//        try {
//            List<String[]> list = POIUtils.readExcel(file);//工具类最后
//            File directory = new File("");//参数为空
//            String courseFile = directory.getCanonicalPath();
//            //将文件存入当前文件夹，并转化成csv文件 （转csv文件）
//            //boolean excel = ListToCvs.createCsvFile(list, courseFile, name);//工具类在最后
//            //专场txt文件
//            if (list != null && list.size() != 0) {
//                String[] strings = list.get(0);
//                int length = strings.length;
//                String field = getListOfFileServiceMapper.getFileOftableAllField(taskId);
//                //文件格式判断
//                String[] title = field.split(",");
//                System.out.println("length-->" + length);
//                System.out.println("title.length-->" + title.length);
//                if (length != title.length) {
//                    publicResp.setMsg("请上传正确的文件！");
//                    publicResp.setRespCode("9999");
//                    return publicResp;
//                }
//            }
//            String dst01 = courseFile + "/" + name + ".txt";
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dst01));
//            for (String[] call : list) {
//                String line = "";
//                for (int i = 0; i < call.length; i++) {
//                    if (i < call.length - 1) {
//                        line += call[i] + "\001";
//                    } else {
//                        line += call[i];
//                    }
//                }
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//                bufferedWriter.flush();
//                line = "";
//            }
//            bufferedWriter.close();
//            //csv文件地址
//            //dst = courseFile +"/"+ name+ ".csv";
//            FileSystem fs = null;
//            Configuration config = new Configuration();
//            config.set("fs.defaultFS", hiveIP);
////            config.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
//            config.set("mapreduce.fileoutputcommitter.marksuccessfuljobs", "false");
//            fs = FileSystem.get(config);
////            Path srcPath = new Path(dst);
//            Path srcPath = new Path(dst01);
//            String path = getListOfFileServiceMapper.getFileOftablePath(taskId);
//            Path dstPath = new Path(path);
//            if (updateExcelOfType.equals("cover")) {
//                //FileStatus[] statuses = fs.listStatus(new Path("/opt/user/hive/warehouse/hmd_api.db/imp_ai_call_list"));
//                FileStatus[] statuses = fs.listStatus(new Path(path));
//                for (FileStatus status : statuses) {
//                    boolean delete = fs.delete(status.getPath(), true);
//                }
//            }
//            fs.copyFromLocalFile(srcPath, dstPath);
//            CreateOrEditInterfacesDto createOrEditInterfacesDto = new CreateOrEditInterfacesDto();
//            createOrEditInterfacesDto.setTaskId(taskId);
//            SimpleDateFormat formatter01 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date01 = new Date(System.currentTimeMillis());
//            String format = formatter01.format(date01);
//            createOrEditInterfacesDto.setDataModifyTime(format);
//            int num = listQueryInterfaceMapper.upDateByExcel(createOrEditInterfacesDto);
//            log.info("upDateByExcel" + num + "成功");
////            filew = new File(dst);
//            filew = new File(dst01);
//        } catch (Exception e) {
//            e.printStackTrace();
//            publicResp.setRespCode("9999");
//            publicResp.setMsg("请上传正确的文件");
//            return publicResp;
//        } finally {
//            SingleConnectionDataSource ds = new SingleConnectionDataSource();
//            ds.setDriverClassName(impalaDriver);
//            ds.setUrl(impalaUrl);
//            ds.setConnectionProperties(new Properties());
//            JdbcTemplate impalaTemplate = new JdbcTemplate(ds);
//            impalaTemplate.setIgnoreWarnings(false);
//            impalaTemplate.execute("invalidate metadata;");
//            if (!ObjectUtils.isEmpty(filew) && filew.exists()) {
//                filew.delete();
//            }
//        }
//        publicResp.setRespCode("0000");
//        return publicResp;
//    }
//
//    @SneakyThrows
//    @Override
//    public String getExcelTemplates(Integer taskId) {
//        String nameBytaskId = getListOfFileServiceMapper.getTaskNameBytaskId(taskId);
//        File directory = new File("");//参数为空
//        String courseFile = directory.getCanonicalPath();
//        String path = courseFile + "\\" + nameBytaskId;
//        File file = new File(path);
//        if (file.exists()) {
//            file.delete();
//        }
//        String field = getListOfFileServiceMapper.getFileOftableAllField(taskId);
//        // 标题
//        String[] title = field.split(",");
//        // 创建一个工作簿
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        // 创建一个工作表sheet
//        HSSFSheet sheet = workbook.createSheet();
//        // 设置列宽
//        setColumnWidth(sheet, 8);
//        // 创建第一行
//        HSSFRow row = sheet.createRow(0);
//        // 创建一个单元格
//        HSSFCell cell = null;
//        // 创建表头
//        for (int i = 0; i < title.length; i++) {
//            cell = row.createCell(i);
//            // 设置样式
//            HSSFCellStyle cellStyle = workbook.createCellStyle();
////            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置字体居中
//            // 设置字体
//            HSSFFont font = workbook.createFont();
//            font.setFontName("宋体");
//            // font.setFontHeight((short)12);
//            font.setFontHeightInPoints((short) 13);
//            cellStyle.setFont(font);
//            cell.setCellStyle(cellStyle);
//            cell.setCellValue(title[i]);
//        }
////        File file = new File(path);
//        try {
//            file.createNewFile();
//            // 打开文件流
//            FileOutputStream outputStream = FileUtils.openOutputStream(file);
//            workbook.write(outputStream);
//            outputStream.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return path;
//    }
//
//    @Override
//    public Boolean dropListOfUpdateExcel(Integer taskId) {
//        int key = 0;
//        String tableName = getListOfFileServiceMapper.getTableByTaskId(taskId);
//        int temp = getListOfFileServiceMapper.updateTbaleByIsUse0(tableName);
//        key = getListOfFileServiceMapper.dropListOfUpdateExcel(taskId);
//        return key == 0;
//    }
//
//    @Override
//    public String getTaskNameById(Integer id) {
//        return getListOfFileServiceMapper.getTaskNameBytaskId(id);
//    }
//
//    @Override
//    public ExcelOfDetialReq addExcelOfDetial(ExcelOfDetialRequest excelOfDetialRequest) {
//        ExcelOfDetialReq excelOfDetialReq = new ExcelOfDetialReq();
//        List<String> list = getListOfFileServiceMapper.getListOfFileOther();
//        if (excelOfDetialRequest.getPathOfHive().contains(".")) {
//            excelOfDetialReq.setRespCode("9999");
//            excelOfDetialReq.setRespMsg("路径非法，请重新联系大数据部门架构组确认路径");
//            return excelOfDetialReq;
//        }
//        if (list.contains(excelOfDetialRequest.getTableName())) {
//            excelOfDetialReq.setRespCode("9999");
//            excelOfDetialReq.setRespMsg("表名称重复");
//            return excelOfDetialReq;
//        }
//
//        ExcelOfDetialDto excelOfDetialDto = new ExcelOfDetialDto();
//        excelOfDetialDto.setTableName(excelOfDetialRequest.getTableName());
//        excelOfDetialDto.setPathOfHive(excelOfDetialRequest.getPathOfHive());
//        excelOfDetialDto.setIsUse(0L);
//        String allFile = "";
//        for (int i = 0; i < excelOfDetialRequest.getTableColumns().size(); i++) {
//            if (i < excelOfDetialRequest.getTableColumns().size() - 1) {
//                allFile += excelOfDetialRequest.getTableColumns().get(i) + ",";
//            } else {
//                allFile += excelOfDetialRequest.getTableColumns().get(i);
//            }
//        }
//        excelOfDetialDto.setAllFile(allFile);
//        if (getListOfFileServiceMapper.addExcelOfDetial(excelOfDetialDto) == 1) {
//            excelOfDetialReq.setRespMsg("创建成功");
//            excelOfDetialReq.setRespCode("0000");
//        }
//        return excelOfDetialReq;
//    }
//
//    @SneakyThrows
//    @Override
//    public Boolean executeShellOforder(ExecuteShellOforderRequest excelOfDetialRequest) {
//        //根据api，其实exec方法可以直接执行命令，但是推荐用数组。
//        //因为如果一些命令中包含特殊符号，命令会失效。经过测试如果直接执行复制命令，
//        //目录可以复制过来，但是目录下的文件会丢失
//        String[] commands = new String[3];
//        commands[0] = new String("/bin/sh");
//        commands[1] = new String("-c");
//        //cp --parents /xian/GC/A/B/* /zi/newLocation
//        //--parents才会将整个目录都复制过去，否则只复制最终的文件
//        //用parents参数的目的就是为了将源端的文件连同文件所在的目录一同复制过来
//        commands[2] = new String("sh /opt/sync/sync_script/sink_doris/hive_load_doris.sh " + excelOfDetialRequest.getOrder());
//        Runtime rt = Runtime.getRuntime();
//        Process proc = null;
//        try {
//            proc = rt.exec(commands);
//        } catch (IOException e) {
//            log.error("执行Linux复制命令出错：{}", e);
//            return false;
//        }
//        return true;
//    }
//
//    // 设置列宽()
//    private static void setColumnWidth(HSSFSheet sheet, int colNum) {
//        for (int i = 0; i < colNum; i++) {
//            int v = 0;
//            v = Math.round(Float.parseFloat("15.0") * 37F);
//            v = Math.round(Float.parseFloat("20.0") * 267.5F);
//            sheet.setColumnWidth(i, v);
//        }
//    }
//
////    @SneakyThrows
////    public static void main(String[] args) {
////        String impalaDriver = "org.apache.hive.jdbc.HiveDriver";
////        String impalaUrl = "jdbc:impala://10.0.15.134:21050/databasename;AuthMech=0;SSL=0";
////        String impalaUsername = "";
////        String impalaPassword = "";
////        Connection conn = null;
////        Class.forName(impalaDriver);
////        conn = (Connection) DriverManager.getConnection(impalaUrl,impalaUsername,impalaPassword);
////        String sql = "select * from kudu_homedo.song_test;";
////        PreparedStatement ps = conn.prepareStatement(sql);
////        ResultSet rs = ps.executeQuery();
////        int col = rs.getMetaData().getColumnCount();
////        System.out.println("=====================================");
////        while (rs.next()){
////            for(int i=1;i<=col;i++){
////                System.out.print(rs.getString(i)+"\t");
////            }
////            System.out.print("\n");
////        }
////
////        SingleConnectionDataSource ds = new SingleConnectionDataSource();
////        ds.setDriverClassName(impalaDriver);
////        ds.setUrl(impalaUrl);
////        ds.setConnectionProperties(new Properties());
////        JdbcTemplate impalaTemplate = new JdbcTemplate(ds);
////        impalaTemplate.setIgnoreWarnings(false);
////        impalaTemplate.execute("invalidate metadata;");
////        System.out.println("=====================================");
////    }
//
//    public String convertStreamToStr(InputStream is) throws IOException {
//        if (is != null) {
//            Writer writer = new StringWriter();
//            char[] buffer = new char[1024];
//            try {
//                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//                int n;
//                while ((n = reader.read(buffer)) != -1) {
//                    writer.write(buffer, 0, n);
//                }
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                is.close();
//            }
//            return writer.toString();
//        } else {
//            return "";
//        }
//    }
//}
//
