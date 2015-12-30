package cc.top.fundation.base.impl;

import cc.top.fundation.utils.PageView;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ���ϳ־ò�Ĺ��õ�����ɾ���ģ�����
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String getClassName(){
		//�ڸ����еõ����������ĸ���ķ�����Ϣ
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class<T> clazz = (Class) pt.getActualTypeArguments()[0];
		//clazz.getSimpleName().toString().toLowerCase(); �����ǻ�ȡʵ����ļ����ƣ��ٰ�����תΪСд
		return clazz.getSimpleName().toString().toLowerCase();
	}
	public void add(T t) {
		getSqlSession().insert(this.getClassName()+".add",t);
	}
	public void delete(String id) {
		getSqlSession().delete(this.getClassName()+".deleteById",id);
	}
	@SuppressWarnings("unchecked")
	public T getById(String id) {
		return (T)getSqlSession().selectOne(this.getClassName()+".getById",id);
	}
	public void modify(T t) {
		getSqlSession().update(this.getClassName()+".update",t);
	}
	public List<T> query(PageView pageView,T t) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("paging", pageView);
		map.put("t", t);
		return getSqlSession().selectList(this.getClassName()+".query",map);
	}
	public List<T> queryAll(T t) {
		return getSqlSession().selectList(this.getClassName()+".queryAll",t);
	}
}
