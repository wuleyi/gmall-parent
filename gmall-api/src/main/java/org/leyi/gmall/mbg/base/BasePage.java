package org.leyi.gmall.mbg.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BasePage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long pageSize;
    private Long totalPage;
    private Long total;
    private Long pageNum;
    private List<T> list;

    public BasePage() {
    }

    public BasePage(IPage page) {
        this.pageSize = page.getSize();
        this.totalPage = page.getPages();
        this.total = page.getTotal();
        this.pageNum = page.getCurrent();
        this.list = page.getRecords();
    }

}
