<script setup lang="ts">
import { computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import logo from '@/assets/logo.png'
import { menuItems } from '@/config/menuConfig'

const router = useRouter()
const route = useRoute()

// 选中菜单跟随路由变化
const selectedKeys = computed(() => [route.path])

const handleMenuClick = ({ key }: { key: string | number }) => {
  router.push(String(key))
}
</script>

<template>
  <a-layout-header class="basic-header">
    <div class="header-left">
      <a class="logo" @click="router.push('/')">
        <img :src="logo" alt="NovusCode" />
        <span class="site-title">NovusCode</span>
      </a>
      <a-menu
        mode="horizontal"
        class="menu"
        :selected-keys="selectedKeys"
        @click="handleMenuClick"
      >
        <a-menu-item v-for="item in menuItems" :key="item.key">
          {{ item.label }}
        </a-menu-item>
      </a-menu>
    </div>
    <div class="header-right">
      <!-- TODO: 登录后替换为用户头像 + 昵称 -->
      <a-button type="primary">登录</a-button>
    </div>
  </a-layout-header>
</template>

<style scoped>
.basic-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding-inline: 24px;
  background: #fff;
  border-bottom: 1px solid #f0f0f0;
}

.header-left {
  display: flex;
  align-items: center;
  gap: 24px;
  flex: 1;
  min-width: 0;
}

.logo {
  display: flex;
  align-items: center;
  gap: 12px;
  flex-shrink: 0;
}

.logo img {
  height: 32px;
}

.site-title {
  color: #001529;
  font-size: 18px;
  font-weight: 600;
}

.menu {
  flex: 1;
  min-width: 0;
}
</style>
