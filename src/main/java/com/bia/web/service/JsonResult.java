package com.bia.web.service;

//@Data
public class JsonResult<T> {
    private int status=1;
    private boolean is_success=true;
    private T resultBody;

    public JsonResult(T resultBody){
        this.resultBody=resultBody;
    }
    public int setStatus(int status){
        this.status=status;
        return status;
    }
    public int getStatus(){
        return this.status;
    }
    public boolean getIs_success(){
        return this.is_success;
    }
    public T getResult(){
        return this.resultBody;
    }

}
