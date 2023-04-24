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


JUNIT5 TESTING ANNOTATION

    ASSERTION
        assertEquals()
        assertArrayEquals()
        assertIterableEquals()
        assertThrows()
        
    HOOKS
        @BeforeAll()
        @AfterAll()
        @BeforeEach()
        @AfterEach()

    @TestInstance(TestInstance.LifeCycle.PER_CLASS)

    @DisplayName()
    @Disabled()
    
    CONDITIONAL EXECUTION
        @EnabledOnOs(OS.LINUX)
        @EnabledOnJRE(JRE.JAVA_11)
        @EnabledIf
        @EnabledIfSystemProperty
        @EnabledIfSystemProperty
        @EnabledIfEnvironmentVariabled

    ASSUMPTION
        assumeThat()
        assumeTrue()

    @AssertAll()

    @Nested

    @RepeatedTest()

    @Tag

    TestInfo/TestReporter -> dependency Injection



