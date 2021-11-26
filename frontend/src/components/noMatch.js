import React from 'react';
import { Col, Container, Row } from 'react-bootstrap';

// import { Container } from './styles';

function NoMatch() {
  return <div>
      <h3 style={{padding:"10px",textAlign:"center"}}>Please Enter A Valid Path</h3>
      <hr/>
      <Container>
        <Row>
          <Col>
          <h4>What is Lorem Ipsum?</h4>
          <p>
Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
          </p>
          </Col>
          <Col>
          <h4>Why do we use it?</h4>
          <p>
Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
          </p></Col>
        </Row>
      </Container>
  </div>;
}

export default NoMatch;