/*
  Diese Testcases dienen nur zur veranschaulichung der Funktionsweise von Cypress-Tests
*/
describe('My First Test', function() {
  
  /*
    Dieser Testcase ruft die Seite auf und prüft ob ein bestimmtes Element vorhanden ist
  */
  it('Does not do much!', function() {
    cy.visit('https://example.cypress.io')
    cy.contains('your')
  })
})
