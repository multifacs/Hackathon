<template>
  <Layout>
    <Header class="header"><h2 class="title">Ищейка</h2></Header>
    <Content>
      <a-space class="form-box" direction="vertical" align="center" size="middle">
        <div><h2>Вход в личный аккаунт</h2></div>
        <div><a-input placeholder="Введите свое имя" /></div>
        <div><a-input placeholder="Введите свой адрес электронной почты" /></div>
        <a-button type="primary" v-on:click="logIn">Вход</a-button>
      </a-space>
    </Content>
  </Layout>
</template>

<script>
export default {
  methods: {
    logIn() {
      this.$store.state.logged = true
      this.$router.push('/dashboard')
    }
  }
}
</script>

<style scoped>
  .title {
    color: #fff;
  }
  .header {
    background-color: #142A4A;
    display: flex;
    justify-content: flex-end;
    padding-right: 10%;
    text-align: end;
    align-items: baseline;
    margin-top: 5%;
  }
  .form-box {
    margin-top: 10%;
    margin-left: 50%;
  }
</style>
