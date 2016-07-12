package doudou.library.com.refresh.normal;

/**
 * 通用的
 * @author liubo
 *         Create at 16/7/11 14:04.
 */
public interface PullAble {
    /**
     * 判断是否可以下拉，如果不需要下拉功能可以直接return false
     *
     * @return true如果可以下拉否则返回false
     */
    boolean canPullDown();

    /**
     * 判断是否可以上拉，如果不需要上拉功能可以直接return false
     *
     * @return true如果可以上拉否则返回false
     */
    boolean canPullUp();
}
