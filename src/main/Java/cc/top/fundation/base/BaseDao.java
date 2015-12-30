package cc.top.fundation.base;
import cc.top.fundation.utils.PageView;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * ���ط�ҳ�������
	 * @param pageView
	 * @param t
	 * @return
	 */
	public List<T> query(PageView pageView, T t);
	/**
	 * ������������
	 * @param t
	 * @return
	 */
	public List<T> queryAll(T t);
	public void delete(String id);
	public void modify(T t);
	public T getById(String id);
	public void add(T t);
}
