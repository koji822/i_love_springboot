package jp.co.commerce21.common.page;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Pager {

	protected int _pageSize;
    protected int _currentPage;
    protected int _count;
    
    public Pager(int pageSize, int count, int currentPage) {
        this._pageSize = pageSize;
        this._count = count;
        this._currentPage = min(currentPage, lastPage());
    }

    public Pager(int pageSize, int maxCount) {
        this(pageSize, maxCount, 1);
    }

    /**
     * 全体の件数を返す
     */
    public int count() {
        return this._count;
    }
    
    /**
     * 1ページあたりの件数を返す
     */
    public int size() {
        return this._pageSize;
    }

    /**
     * 現在のページを返す
     */
    public int currentPage() {
        return this._currentPage;
    }

    /**
     * 最終ページを返す
     */
    public int lastPage() {
        if (_count == 0) {
            return 1;
        } else if ((_count % _pageSize) == 0){
            return _count / _pageSize;
        } else {
            return (_count / _pageSize) + 1;
        }
    }
    
    /**
     * 前ページを返す
     */
    public int prevPage() {
        return max(1, _currentPage - 1);
    }
    
    /**
     * 前ページがあるかどうか返す
     */
    public boolean hasPrev() {
        return _currentPage != prevPage();
    }
    
    /**
     * 次ページを返す
     */
    public int nextPage() {
        return min(_currentPage + 1, lastPage());
    }
    
    /**
     * 次ページがあるかどうか返す
     */
    public boolean hasNext() {
        return _currentPage != nextPage();
    }
    
    /**
     * ページが何件目から表示されるか返す
     */
    public int offset() {
        return min(this._count, ((this._currentPage - 1) * _pageSize));
    }
    
    /**
     * ページが何件目まで表示されるか返す
     */
    public long endPos() {
        return min(this._count, (this._currentPage) * _pageSize);
    }
}
