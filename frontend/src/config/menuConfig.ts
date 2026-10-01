/**
 * 全局导航菜单配置
 * 新增菜单项时，在数组中追加即可（key 需对应路由路径）
 */
export interface MenuConfig {
  key: string
  label: string
}

export const menuItems: MenuConfig[] = [
  {
    key: '/',
    label: '首页',
  },
]
