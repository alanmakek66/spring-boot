package com.bootcamp.demo_tax.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bootcamp.demo_tax.infa.NotFoundException;
import com.bootcamp.demo_tax.model.DLRI;
import com.bootcamp.demo_tax.model.Scheme;
import com.bootcamp.demo_tax.service.DlriService;

@Service
public class DlriServiceImpl implements DlriService {

  @Value(value = "${api.www-itc-gov-hk.domain}") // request = true;
  private String domain;

  @Value(value = "${api.www-itc-gov-hk.endpoints.user}")
  private String usersEndpoint;

  @Override
  public List<DLRI> callApi() {

    String uri = UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.name())
        .host(this.domain)
        .path(this.usersEndpoint)
        .toUriString();

    DLRI[] d1 = new RestTemplate().getForObject(uri, DLRI[].class);

    return Arrays.asList(d1);

  }

  @Override
  public DLRI callApi2(String id) throws NotFoundException {
    String uri = UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.name())
        .host(this.domain)
        .path(this.usersEndpoint)
        .toUriString();

    DLRI[] d1 = new RestTemplate().getForObject(uri, DLRI[].class);

    List<DLRI> dd1 = Arrays.asList(d1);

    DLRI result = dd1.stream().filter(e -> id.equalsIgnoreCase(e.getId()))
        .findFirst().orElseThrow(() -> new NotFoundException());

    return result;

  }

  @Override
  public DLRI callApi3(String email) throws NotFoundException{

    String uri = UriComponentsBuilder.newInstance().scheme(Scheme.HTTPS.name())
        .host(this.domain)
        .path(this.usersEndpoint)
        .toUriString();

    DLRI[] d1 = new RestTemplate().getForObject(uri, DLRI[].class);

    List<DLRI> dd1 = Arrays.asList(d1);

    DLRI result = dd1.stream().filter(e -> email.equalsIgnoreCase(e.getEmail()))
        .findFirst().orElseThrow(() -> new NotFoundException());

    return result;


  }

}
