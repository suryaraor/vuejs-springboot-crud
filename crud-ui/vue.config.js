module.exports = {
  devServer: {
    proxy: {
      '^/api': {
        target: 'http://localhost:9191',
        changeOrigin: true,
        logLevel: 'debug',
        pathRewrite: { '^/api': '/' },
      },
    },
  },
}
