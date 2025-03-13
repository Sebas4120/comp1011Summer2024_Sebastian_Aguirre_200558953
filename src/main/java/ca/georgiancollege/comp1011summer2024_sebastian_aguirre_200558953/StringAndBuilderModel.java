package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953;

public class StringAndBuilderModel {


    private String dataType, content, method, args, result;

    private DBUtil db = new DBUtil("comp1011");


    public StringAndBuilderModel(String dataType, String content, String method, String args) {
        setDataType(dataType);
        setContent(content);
        setMethod(method);
        setArgs(args);


        db.setTable("StringAndStringBuilder");


    }
    public void insertEntry() throws Exception{

        String sql = String.format(
                "INSERT into %s (content, args, method, datatype) VALUES ('%s','%s','%s','%s')",
                db.getTable(), content, args, method, dataType);
        db.queryExec(sql);
    }


    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
