package zy.news.common.db;

/**
 * mybatis 筛选匹配规则
 *
 * @author fanpei
 */
public enum DbMatchRule {
	/**
	 * 完全相等
	 */
	EqualTo(0),
	/**
	 * 在集合之内
	 */
	In(1),
	/**
	 *不在集合之内
	 */
	NotIn(2),
	/**
	 * 模糊匹配
	 * */
	Like(3),
	/**
	 * 模糊匹配之外的
	 * */
	NotLike(4),
	/**
	 *在起始范围之间*
	 *
	 */
	Between(5),
	/**
	 * 小于某值
	 * */
	LessThan(6),
	/**
	 * 小于或等于某值
	 * */
	LessThanOrEqualTo(7),
	/**
	 * 大于某值
	 * */
	GreaterThan(8),
	/**
	 * 大于或等于某值
	 * */
	GreaterThanOrEqualTo(9),
	/**
	 * 不等于
	 * */
	NotEqualTo(10),
	/**
	 * 排序参数
	 * */
	OrderByClause(11),
	/**
	 * 分组参数
	 * */
	GroupbyClause(12),
	/**
	 * 为空
	 * */
	IsNull(13);

	private byte value;

	public byte getValue() {
		return value;
	}

	private DbMatchRule(int value) {
		this.value = (byte) value;
	}

	public static DbMatchRule getDbMatchRule(byte rule) {
		DbMatchRule type = DbMatchRule.EqualTo;
		switch (rule) {
		case 0:
			type = DbMatchRule.EqualTo;
			break;
		case 1:
			type = DbMatchRule.In;
			break;
		case 2:
			type = DbMatchRule.NotIn;
			break;
		case 3:
			type = DbMatchRule.Like;
			break;
		case 4:
			type = DbMatchRule.NotLike;
			break;
		case 5:
			type = DbMatchRule.Between;
			break;
		case 6:
			type = DbMatchRule.LessThan;
			break;
		case 7:
			type = DbMatchRule.LessThanOrEqualTo;
			break;
		case 8:
			type = DbMatchRule.GreaterThan;
			break;
		case 9:
			type = DbMatchRule.GreaterThanOrEqualTo;
			break;
		case 10:
			type = DbMatchRule.NotEqualTo;
			break;
		case 11:
			type = DbMatchRule.OrderByClause;
			break;
		case 12:
			type = DbMatchRule.GroupbyClause;
			break;
		case 13:
			type = DbMatchRule.IsNull;
			break;
		default:
			break;
		}
		return type;
	}

	public String rule2oper() {
		return rule2operString(this);
	}

	public static String rule2operString(DbMatchRule rule) {
		String oper = "=";
		switch (rule) {
		case EqualTo:
			break;
		case GreaterThan:
			oper = ">";
			break;
		case GreaterThanOrEqualTo:
			oper = ">=";
			break;
		case LessThan:
			oper = "<";
			break;
		case LessThanOrEqualTo:
			oper = "<=";
			break;
		case Like:
			oper = "like";
			break;
		case NotLike:
			oper = "not like";
			break;
		case In:
			oper = "in";
			break;
		case NotEqualTo:
			oper = "<>";
			break;
		case Between:
			oper = "between";
			break;
		default:
			break;

		}
		return oper;
	}
}
