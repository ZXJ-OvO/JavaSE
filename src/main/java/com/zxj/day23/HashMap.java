
package com.zxj.day23;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;


public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
//    // 序列号
//    private static final long serialVersionUID = 362498820763181265L;
//    // 默认的初始容量是16
//    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//    // 最大容量
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//    // 默认的负载因子
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//    // 当桶(bucket)上的结点数大于等于这个值时会转成红黑树
//    static final int TREEIFY_THRESHOLD = 8;
//    // 当桶(bucket)上的结点数小于等于这个值时树转链表
//    static final int UNTREEIFY_THRESHOLD = 6;
//    // 桶中结构转化为红黑树对应的table的最小容量
//    static final int MIN_TREEIFY_CAPACITY = 64;
//    // 存储元素的数组，总是2的幂次倍
//    transient Node<K, V>[] table;
//    // 存放具体元素的集
//    transient Set<Map.Entry<K, V>> entrySet;
//    // 存放元素的个数，注意这个不等于数组的长度。
//    transient int size;
//    // 每次扩容和更改map结构的计数器
//    transient int modCount;
//    // 阈值(容量*负载因子) 当实际大小超过阈值时，会进行扩容
//    int threshold;
//    // 负载因子
//    final float loadFactor;
//
//    /**
//     * 扰动函数
//     */
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    /**
//     * 节点
//     */
//    static class Node<K, V> implements Map.Entry<K, V> {
//        final int hash;// 哈希值，存放元素到hashmap中时用来与其他元素hash值比较
//        final K key;//键
//        V value;//值
//        Node<K, V> next;        // 指向下一个节点
//
//        Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public final K getKey() {
//            return key;
//        }
//
//        public final V getValue() {
//            return value;
//        }
//
//        public final String toString() {
//            return key + "=" + value;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//            if (o instanceof Map.Entry) {
//                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
//                if (Objects.equals(key, e.getKey()) &&
//                        Objects.equals(value, e.getValue()))
//                    return true;
//            }
//            return false;
//        }
//    }
//
//    /**
//     * 默认构造器为负载因子设置默认值
//     */
//    public HashMap() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//    }
//
//    /**
//     * 树节点
//     */
//    static final class TreeNode<K, V> extends Entry<K, V> {
//        TreeNode<K, V> parent;  // red-black tree links
//        TreeNode<K, V> left;
//        TreeNode<K, V> right;
//        TreeNode<K, V> prev;    // needed to unlink next upon deletion
//        boolean red;
//
//        TreeNode(int hash, K key, V val, Node<K, V> next) {
//            super(hash, key, val, next);
//        }
//
//        final TreeNode<K, V> root() {
//            for (TreeNode<K, V> r = this, p; ; ) {
//                if ((p = r.parent) == null)
//                    return r;
//                r = p;
//            }
//        }
//
//    }
//
//    /**
//     * 树节点继承的Entry
//     */
//    static class Entry<K, V> extends Node<K, V> {
//        Entry<K, V> before, after;
//
//        Entry(int hash, K key, V value, Node<K, V> next) {
//            super(hash, key, value, next);
//        }
//    }
//
//    public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//    }
//
//    @NotNull
//    @Override
//    public Set<Map.Entry<K, V>> entrySet() {
//        return null;
//    }
//
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
//        Node<K, V>[] tab;
//        Node<K, V> p;
//        int n, i;
//        // table未初始化或者长度为0，进行扩容
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//        // (n - 1) & hash 确定元素存放在哪个桶中，桶为空，新生成结点放入桶中(此时，这个结点是放在数组中)
//        if ((p = tab[i = (n - 1) & hash]) == null)
//            tab[i] = newNode(hash, key, value, null);
//            // 桶中已经存在元素（处理hash冲突）
//        else {
//            Node<K, V> e;
//            K k;
//            //快速判断第一个节点table[i]的key是否与插入的key一样，若相同就直接使用插入的值p替换掉旧的值e。
//            if (p.hash == hash &&
//                    ((k = p.key) == key || (key != null && key.equals(k))))
//                e = p;
//                // 判断插入的是否是红黑树节点
//            else if (p instanceof TreeNode)
//                // 放入树中
//                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value);
//                // 不是红黑树节点则说明为链表结点
//            else {
//                // 在链表最末插入结点
//                for (int binCount = 0; ; ++binCount) {
//                    // 到达链表的尾部
//                    if ((e = p.next) == null) {
//                        // 在尾部插入新结点
//                        p.next = newNode(hash, key, value, null);
//                        // 结点数量达到阈值(默认为 8 )，执行 treeifyBin 方法
//                        // 这个方法会根据 HashMap 数组来决定是否转换为红黑树。
//                        // 只有当数组长度大于或者等于 64 的情况下，才会执行转换红黑树操作，以减少搜索时间。否则，就是只是对数组扩容。
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);
//                        // 跳出循环
//                        break;
//                    }
//                    // 判断链表中结点的key值与插入的元素的key值是否相等
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        // 相等，跳出循环
//                        break;
//                    // 用于遍历桶中的链表，与前面的e = p.next组合，可以遍历链表
//                    p = e;
//                }
//            }
//            // 表示在桶中找到key值、hash值与插入元素相等的结点
//            if (e != null) {
//                // 记录e的value
//                V oldValue = e.value;
//                // onlyIfAbsent为false或者旧值为null
//                if (!onlyIfAbsent || oldValue == null)
//                    //用新值替换旧值
//                    e.value = value;
//                // 访问后回调
//                afterNodeAccess(e);
//                // 返回旧值
//                return oldValue;
//            }
//        }
//        // 结构性修改
//        ++modCount;
//        // 实际大小大于阈值则扩容
//        if (++size > threshold)
//            resize();
//        // 插入后回调
//        afterNodeInsertion(evict);
//        return null;
//    }
//
//    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
//        return new Node<K,V>(hash, key, value, next);
//    }
//
//    final TreeNode<K, V> putTreeVal(HashMap<K, V> map, Node<K, V>[] tab, int h, K k, V v) {
//        Class<?> kc = null;
//        boolean searched = false;
//        TreeNode<K, V> root = (parent != null) ? root() : this;
//        for (TreeNode<K, V> p = root; ; ) {
//            int dir, ph;
//            K pk;
//            if ((ph = p.hash) > h)
//                dir = -1;
//            else if (ph < h)
//                dir = 1;
//            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
//                return p;
//            else if ((kc == null &&
//                    (kc = comparableClassFor(k)) == null) ||
//                    (dir = compareComparables(kc, k, pk)) == 0) {
//                if (!searched) {
//                    TreeNode<K, V> q, ch;
//                    searched = true;
//                    if (((ch = p.left) != null &&
//                            (q = ch.find(h, k, kc)) != null) ||
//                            ((ch = p.right) != null &&
//                                    (q = ch.find(h, k, kc)) != null))
//                        return q;
//                }
//                dir = tieBreakOrder(k, pk);
//            }
//
//            TreeNode<K, V> xp = p;
//            if ((p = (dir <= 0) ? p.left : p.right) == null) {
//                Node<K, V> xpn = xp.next;
//                TreeNode<K, V> x = map.newTreeNode(h, k, v, xpn);
//                if (dir <= 0)
//                    xp.left = x;
//                else
//                    xp.right = x;
//                xp.next = x;
//                x.parent = x.prev = xp;
//                if (xpn != null)
//                    ((TreeNode<K, V>) xpn).prev = x;
//                moveRootToFront(tab, balanceInsertion(root, x));
//                return null;
//            }
//        }
//    }
//
//    final Node<K, V>[] resize() {
//        Node<K, V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//        int newCap, newThr = 0;
//        if (oldCap > 0) {
//            // 超过最大值就不再扩充了，就只好随你碰撞去吧
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            // 没超过最大值，就扩充为原来的2倍
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        } else if (oldThr > 0) // initial capacity was placed in threshold
//            // 创建对象时初始化容量大小放在threshold中，此时只需要将其作为新的数组容量
//            newCap = oldThr;
//        else {
//            // signifies using defaults 无参构造函数创建的对象在这里计算容量和阈值
//            newCap = DEFAULT_INITIAL_CAPACITY;
//            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//        }
//        if (newThr == 0) {
//            // 创建时指定了初始化容量或者负载因子，在这里进行阈值初始化，
//            // 或者扩容前的旧容量小于16，在这里计算新的resize上限
//            float ft = (float) newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
//        }
//        threshold = newThr;
//        @SuppressWarnings({"rawtypes", "unchecked"})
//        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
//        table = newTab;
//        if (oldTab != null) {
//            // 把每个bucket都移动到新的buckets中
//            for (int j = 0; j < oldCap; ++j) {
//                Node<K, V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)
//                        // 只有一个节点，直接计算元素新的位置即可
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode)
//                        // 将红黑树拆分成2棵子树，拆分后的子树节点数小于等于6，则将树转化成链表
//                        ((TreeNode<K, V>) e).split(this, newTab, j, oldCap);
//                    else {
//                        Node<K, V> loHead = null, loTail = null;
//                        Node<K, V> hiHead = null, hiTail = null;
//                        Node<K, V> next;
//                        do {
//                            next = e.next;
//                            // 原索引
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            // 原索引+oldCap
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        // 原索引放到bucket里
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        // 原索引+oldCap放到bucket里
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
//
//    final Node<K, V> getNode(int hash, Object key) {
//        Node<K, V>[] tab;
//        Node<K, V> first, e;
//        int n;
//        K k;
//        if ((tab = table) != null && (n = tab.length) > 0 &&
//                (first = tab[(n - 1) & hash]) != null) {
//            if (first.hash == hash && // always check first node
//                    ((k = first.key) == key || (key != null && key.equals(k))))
//                return first;
//            if ((e = first.next) != null) {
//                if (first instanceof TreeNode)
//                    return ((TreeNode<K, V>) first).getTreeNode(hash, key);
//                do {
//                    if (e.hash == hash &&
//                            ((k = e.key) == key || (key != null && key.equals(k))))
//                        return e;
//                } while ((e = e.next) != null);
//            }
//        }
//        return null;
//    }
//
//    final TreeNode<K,V> getTreeNode(int h, Object k) {
//        return ((parent != null) ? root() : this).find(h, k, null);
//    }
//
//    /**
//     * 决定是否转为红黑树
//     */
//    final void treeifyBin(Node<K, V>[] tab, int hash) {
//        int n, index;
//        Node<K, V> e;
//        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
//            resize();
//        else if ((e = tab[index = (n - 1) & hash]) != null) {
//            TreeNode<K, V> hd = null, tl = null;
//            do {
//                TreeNode<K, V> p = replacementTreeNode(e, null);
//                if (tl == null)
//                    hd = p;
//                else {
//                    p.prev = tl;
//                    tl.next = p;
//                }
//                tl = p;
//            } while ((e = e.next) != null);
//            if ((tab[index] = hd) != null)
//                hd.treeify(tab);
//        }
//    }
//
//    @Override
//    public void forEach(BiConsumer<? super K, ? super V> action) {
//        Node<K, V>[] tab;
//        if (action == null)
//            throw new NullPointerException();
//        if (size > 0 && (tab = table) != null) {
//            int mc = modCount;
//            for (int i = 0; i < tab.length; ++i) {
//                for (Node<K, V> e = tab[i]; e != null; e = e.next)
//                    action.accept(e.key, e.value);
//            }
//            if (modCount != mc)
//                throw new ConcurrentModificationException();
//        }
//    }

}
