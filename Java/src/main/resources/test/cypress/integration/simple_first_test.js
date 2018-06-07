describe('My First Test', function() {
  it('Does not do much!', function() {
    cy.visit('https://example.cypress.io')
    cy.contains('your')
  })
})