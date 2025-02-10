import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from "path"

// https://vite.dev/config/
export default defineConfig({
  alias: {
    "@": path.resolve(__dirname, "./src"),
  },
  plugins: [react()],
  server: {
    hmr: {
      overlay: false, // Prevents the error overlay from blocking UI
    },
  },
  
})
