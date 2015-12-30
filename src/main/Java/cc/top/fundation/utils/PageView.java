
package cc.top.fundation.utils;

import java.util.List;


/**
 * //��ҳ��װ����
 */
@SuppressWarnings("unchecked")
public class PageView {
    /**
     * ��ҳ����
     */
    private List records;

    /**
     * ҳ��Ŀ�ʼ������
     * ����������
     * startindex����ʼ����
     * endindex������������
     * ������Ǽ��������
     */
    public PageIndex pageindex;

    /**
     * ��ҳ��
     * ������Ǽ��������
     *
     */
    private long pageCount;


    /**
     * ÿҳ��ʾ������¼
     */
    private int pageSize = 10;


    /**
     *Ĭ�� ��ǰҳ Ϊ��һҳ
     *������Ǽ��������
     */
    private int pageNow = 1;

    /**
     * �ܼ�¼��
     */
    private long rowCount;

    /**
     * �ӵڼ�����¼��ʼ
     */
    private int startPage;

    /**
     * �涨��ʾ5��ҳ��
     */
    private int pagecode = 5;
    public PageView() {
    }

    /**
     * Ҫ��ü�¼�Ŀ�ʼ������������ʼҳ��
     * @return
     */
    public int getFirstResult(){
        return (this.pageNow-1)* this.pageSize;
    }

    public int getPagecode() {
        return pagecode;
    }

    public void setPagecode(int pagecode) {
        this.pagecode = pagecode;
    }

    /**
     * ʹ�ù��캯������ǿ�Ʊ�������
     * ÿҳ��ʾ�������͡���ǰҳ
     * @param pageSize����ÿҳ��ʾ����
     * @param pageNow����ǰҳ
     */
    public PageView(int pageSize, int pageNow){
        this.pageSize = pageSize;
        this.pageNow = pageNow;
    }

    /**
     * ʹ�ù��캯������ǿ�Ʊ�������
     * ��ǰҳ
     * @param pageNow����ǰҳ
     */
    public PageView(int pageNow){
        this.pageNow = pageNow;
        startPage = (this.pageNow - 1) * this.pageSize;
    }
    /**
     * ��ѯ�������
     * �ѡ���¼����������ϡ����뵽��PageView����
     * @param rowCount �ܼ�¼��
     * @param records �������
     */

    public void setQueryResult(long rowCount, List records){
        setRowCount(rowCount);
        setRecords(records);
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
        setPageCount(this.rowCount % this.pageSize == 0?
                        this.rowCount/this.pageSize :
                        this.rowCount/this.pageSize+1
        );
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }


    public PageIndex getPageindex() {
        return pageindex;
    }

    public void setPageindex(PageIndex pageindex) {
        this.pageindex = pageindex;
    }


    /**
     * WebTool����һ����ҳ������
     * @author Administrator
     *
     *��pagecode��Ҫ��ü�¼�Ŀ�ʼ������������ʼҳ��
     *  pageNow ����ǰҳ
     *��pageCount ��ҳ��
     *
     *  ��������ࡡ���ص���ҳ������PageIndex
     *
     *  ����������д���һ�����⣬ÿҳ��ʾ�������͡���ǰҳ��������Ϊ��
     *  ��������
     */
    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
        this.pageindex = WebTool.getPageIndex(pagecode, pageNow, pageCount);
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public long getPageCount() {
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getRowCount() {
        return rowCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }


}
