import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import{ElementPlusResolver }from 'unplugin-vue-components/resolvers'
import ElementPlus from 'unplugin-element-plus/vite'
import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
// import ElementPlus from "element-plus";

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    ElementPlus({
      useSource: true,
    }),
AutoImport({
  resolvers: [ElementPlusResolver({importstyle: 'sass'})],
}),
  Components({
    resolvers: [ElementPlusResolver({importStyle: 'sass'})],
  }),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  css: {
    preprocessorOptions: {
      scss: {
//自动导入定制化样式文件进行样式覆盖
        additionalData:`
        @use "@/assets/index.scss" as *;
      `,
        api:'modern-compiler'
    }
  }
},
})
