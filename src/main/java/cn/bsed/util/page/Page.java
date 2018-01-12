package cn.bsed.util.page;

/**
 * <p>
 *  分页类
 * @author SQM
 * @create 2018/1/11
 */
public class Page {
    
    /**
     *<p>开始页数
     */
    private int start;

    /**
     *<p>每页显示个数
     */
    private int count;

    /**
     * <p>总个数
     */
    private int total;

    /**
     * <p>参数
     */
    private String param;

    /**
     * <p>默认每页显示条数
     */
    private static final int DEFAULT_COUNT = 5;

    public Page() {
        count = DEFAULT_COUNT;
    }

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    /**
     *<p>获取总分页数
     *
     *@return int   总分页个数
     */
    public int getTotalPage() {
        //总页数
        int totalPage;
        //总个数除以每页显示个数
        int pages = total / count;
        //若总个数不能被每页显示个数整除，则总页数加一页
        if (total % count != 0) {
            totalPage = pages + 1;
        } else {
            //若总个数能被每页显示个数整除，则总页数不加一
            totalPage = pages;
        }
        //若总页数计算得0，则赋值为1
        if (totalPage == 0) {
            totalPage = 1;
        }
        return totalPage;
    }

    /**
     * <p>获取最后一页的开始个数
     *
     * @return int 获取最后一页的开始个数
     */
    public int getLast() {
        int last;
        int remainder = total % count;
        //判断如果总个数不能被每页显示个数整除，则最后一页的开始个数为总个数减去余数
        if (remainder != 0) {
            last = total - remainder;
            last = last < 0 ? 0 : last;
        } else {
            last = total - count;
        }
        return last;
    }

    /**
     *<p>判断此page实例是否是第一个page
     *
     *@return boolean   是返回true，否返回false
     */
    public boolean isHasPrevious() {
        return !(start == 0);
    }

    /**
     * <p>判断此page实例是否是最后一个page
     *
     * @return boolean
     */
    public boolean isHasNext() {
        return !(start == getLast());
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", param='" + param +
                ", getTotalPage()=" + getTotalPage() +
                ", getLast()=" + getLast() +
                ", isHasPrevious()" + isHasPrevious() +
                ", isHasNext()" + isHasNext() +
                '}';
    }
}
