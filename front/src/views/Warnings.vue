<template>
    <div>
        <CCard class="card no-border no-background" v-if="$store.state.warnings.length">
            <CCardHeader class="no-border no-background card-header">
                <span class="text header">
                    Данные объекты находятся в зоне повышенной опасности
                </span>
            </CCardHeader>
            <CCardBody class="card-body no-border">
                <CListGroup>
                    <CListGroupItem v-for="(warn, i) in $store.state.warnings" v-bind:key="i" 
                      class="container no-border">
                        <CContainer>
                            <CRow alignHorizontal="center">
                                <span class="text tourist-name">{{ warn.touristName }}</span>
                            </CRow>
                            <CRow alignHorizontal="between" alignVertical="center" class="second-row">
                                <CCol md="2">
                                    <CIcon src="warn.png" size="lg"/>
                                </CCol>
                                <CCol md="6">
                                    <span class="text message">{{ warn.message }}</span>
                                </CCol>
                                <CCol md="4">
                                    <CButton
                                        variant="ghost"
                                        color="warning"
                                        size="lg"
                                    >
                                        Посмотреть на карте
                                    </CButton>
                                </CCol>
                            </CRow>
                        </CContainer>
                    </CListGroupItem>
                </CListGroup>
            </CCardBody>
        </CCard>
        <CCard class="card no-border no-background" v-else>
            <CCardHeader class="no-border no-background card-header">
                <span class="text header">
                    Предупреждений нет
                </span>
            </CCardHeader>
        </CCard>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                warnings: []
            }
        },
        
    }
</script>

<style scoped>
.card-body {
    background-color: #22456E;
    opacity: 0.8;
    border-radius: 15px;
}
.second-row {
    text-align: center;
    margin-top: 10px;
}
.tourist-name {
    line-height: 90px;
    font-size: 60px;
}
.container {
    margin-bottom: 20px;
}
.header {
    color: #000000;
    line-height: 43px;
    font-weight: 500;
}
.card-header {
    text-align: center;
}
.no-border {
    border: none;
}
.no-background {
    background: none;
}
.message {
    font-size: 20px;
}
</style>